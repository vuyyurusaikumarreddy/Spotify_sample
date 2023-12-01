package com.example.Spotify_sample.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spotify_sample.models.Playlists;
import com.example.Spotify_sample.models.Tracks;
import com.example.Spotify_sample.repositories.PlaylistsRepository;
import com.example.Spotify_sample.repositories.TracksRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class MainController {
    
    @Autowired
    PlaylistsRepository playlistsRepository;

    @Autowired
    TracksRepository tracksRepository;

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
        return tracks;
    }
}