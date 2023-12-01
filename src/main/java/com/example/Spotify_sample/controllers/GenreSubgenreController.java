package com.example.Spotify_sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spotify_sample.models.GenreSubgenre;
import com.example.Spotify_sample.repositories.GenreSubGenreRepository;

@RestController
public class GenreSubgenreController {
    
    @Autowired
    GenreSubGenreRepository genreSubGenreRepository;

    @GetMapping("gen")
    public GenreSubgenre get() {
        
        return genreSubGenreRepository.findByGenre(null);
    }
}
