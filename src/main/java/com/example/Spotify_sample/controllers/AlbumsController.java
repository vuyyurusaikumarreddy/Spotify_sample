package com.example.Spotify_sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spotify_sample.models.Albums;
import com.example.Spotify_sample.repositories.AlbumsRepository;

@RestController
public class AlbumsController {
    
    @Autowired
    AlbumsRepository albumsRepository;

    @PostMapping("/albums/insert")
    public Albums insertAlbums(@RequestBody Albums album) {
        albumsRepository.save(album);
        return album;
    }

}
