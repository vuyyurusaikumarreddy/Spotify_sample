package com.example.Spotify_sample.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spotify_sample.models.Playlists;
import com.example.Spotify_sample.models.Tracks;
import com.example.Spotify_sample.repositories.GenreSubGenreRepository;
import com.example.Spotify_sample.repositories.PlaylistsRepository;
import com.example.Spotify_sample.repositories.TracksRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/", "http://localhost:3000/Home"}, allowCredentials = "true")
public class MainController {
    
    @Autowired
    PlaylistsRepository playlistsRepository;

    @Autowired
    TracksRepository tracksRepository;

    @Autowired
    GenresController genresController;

    @Autowired
    SubGenresController subGenresController;

    @Autowired
    GenreSubGenreRepository genreSubGenreRepository;

    @Autowired
    GenreSubgenreController genreSubgenreController;

    @GetMapping("/playlists/genre/{genre_name}")
    public List<Playlists> getPlaylistsByGenre(@PathVariable String genre_name) {
        List<Playlists> playlists = playlistsRepository.findByGenre(genre_name);
        return playlists;
    
    }

    @GetMapping("/playlists/subgenre/{subgenre_name}")
    public List<Playlists> getPlaylistsBySubGenre(@PathVariable String subgenre_name) throws JsonMappingException, JsonProcessingException {
        List<Playlists> playlists = playlistsRepository.findBySubGenre(subgenre_name);
        return playlists;
    
    }

    @GetMapping("/tracks/artist/{artist_name}")
    public List<Map<String, Object>> getTracksByArtist(@PathVariable String artist_name) {
        List<Map<String, Object>> tracks = tracksRepository.findByArtists(artist_name).get();

        return tracks;

    }

    @GetMapping("/tracks/album/{album_name}")
    public List<Map<String, Object>> getTracksByAlbum(@PathVariable String album_name) {
        List<Map<String, Object>> tracks = tracksRepository.findByAlbum(album_name).get();
        // for(int i=0;i<tracks.size();i++) {
        //     tracks.get(i).put("tracks", Arrays.asList(tracks.get(i).get("tracks").toString().split(",&& ")));
        // }
        
        return tracks;
    }

    @GetMapping("/tracks/{track_name}")
    public List<Tracks> getTracks(@PathVariable String track_name) {
        List<Tracks> track = tracksRepository.findByName(track_name).get();
        return track;
    }

    @GetMapping("/tracks/search")
    public List<String> getTracksParam(@RequestParam String track_name) {
        List<String> tracks = tracksRepository.findByNameParam(track_name).get();
        return tracks;
    }
    
    @GetMapping("/tracks")
    public List<String> getTracks() {
        List<String> trackNames = tracksRepository.findNames();
        return trackNames.subList(0, 20);
    }

    @PostMapping("/tracks/insertTrack")
    public ResponseEntity<String> insertTrack(@RequestBody Tracks track) {

        tracksRepository.save(track);

        return ResponseEntity.status(HttpStatus.CREATED).body("Track with album inserted succesfully");
    }


    // @DeleteMapping("/tracks/name")

    // private void convertDuplicatesToList(List<Map<String, Object>> mapList, String album, String track) {
    //     if(mapList.size()>0)
    //     {
    //         for (Map<String, Object> map : mapList) {
    //             if (map.containsValue(album)) {
    //                 ((List<String>) map.get("track")).add(track);
    //             }
    //             else {
    //                 List<String> tracks = new ArrayList<>();
    //                 tracks.add(track);
    //                 map.put("track", tracks);
    //             }
    //         }
    //     }
    //     else {
    //         Map<String, Object> map = new HashMap<>();
    //         map.put("album", album);
    //         List<String> tracks = new ArrayList<>();
    //         tracks.add(track);
    //         map.put("track", tracks);
    //         mapList.add(map);
    //     }
    // }

    @PostMapping("/playlists/createPlaylist")
    public ResponseEntity<String> createPlaylist(@RequestBody Map<String, Object> playlists) {
        if(playlists.get("playlist_name") == null || playlists.get("playlist_name").toString().isEmpty() || playlists.get("playlist_name").toString().isBlank()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please give the playlist name");
        }
        String playlist_name = playlists.get("playlist_name").toString();
        String playlist_id = playlists.get("playlist_id").toString();

            if(playlists.get("genre") == null || playlists.get("subGenre") == null ) {
                playlistsRepository.insertPlaylist(playlist_id, playlist_name, (Integer)playlists.get("playlist_info"));
                return ResponseEntity.status(HttpStatus.CREATED).body("Playlist " + playlist_name + "succesfully");
        
            }
            int id = genreSubgenreController.getGenreSubgenreByGenreIdAndSubGenreId(genresController.findGenreIdByName(playlists.get("genre").toString()).get(0).getId(), subGenresController.searchByName(playlists.get("subGenre").toString()).get(0).getId());
            playlistsRepository.insertPlaylist(playlists.get("playlist_id").toString(), playlists.get("playlist_name").toString(), id);

            return ResponseEntity.status(HttpStatus.CREATED).body("Playlist " + playlists.get("playlist_name") + "succesfully");
        }

        
    }
