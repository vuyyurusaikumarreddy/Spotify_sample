package com.example.Spotify_sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("genreSubgenre")
    public int getGenreSubgenreByGenreIdAndSubGenreId(@RequestParam int genre_id, int subgenre_id) {
        
        int id = 0;
            try {
                id = genreSubGenreRepository.findIdByGenreAndSubGenre(genre_id, subgenre_id);
            } catch (Exception e) {
                
                genreSubGenreRepository.insertGenreSubgenre(genre_id, subgenre_id);
                id = genreSubGenreRepository.findIdByGenreAndSubGenre(genre_id, subgenre_id);
            }
        return genreSubGenreRepository.findIdByGenreAndSubGenre(genre_id, subgenre_id);
    }
}
