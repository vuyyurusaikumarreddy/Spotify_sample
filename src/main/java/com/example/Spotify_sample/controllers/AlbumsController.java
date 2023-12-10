package com.example.Spotify_sample.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spotify_sample.models.Albums;
import com.example.Spotify_sample.repositories.AlbumsRepository;

@RestController
@RequestMapping("/albums")
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class AlbumsController {
    
    @Autowired
    AlbumsRepository albumsRepository;

    @GetMapping("/getAlbums")
    public List<String> getAllAlbums() {
        List<String> albums = albumsRepository.findNames();
        return albums;
    }

    @PostMapping("/insert")
    public Albums insertAlbums(@RequestBody Albums album) {
        albumsRepository.save(album);
        return album;
    }

    @GetMapping("/getAlbumsAndArtist")
    public List<Map<String, Object>> getAlbumsWithArtist() {
        List<Map<String, Object>> albums = albumsRepository.findAlbumsAndArtist();
        return albums;
    }
    @GetMapping("")
    public List<Albums> getAlbumsByName(@RequestParam String albumName) {
        return albumsRepository.findByName(albumName);
    }

    @GetMapping("/artist")
    public List<String> getAlbumsByArtist(@RequestParam String artist_name) {
        return albumsRepository.findByArtist(artist_name);
    }

    @GetMapping("/{genre}")
    public List<Albums> getAlbumsByGenre(@PathVariable String genre) {
        List<Albums> albums = new ArrayList<>();
        // albumsRepository.findByGenre(genre);
        return albums;
    }

}
