package com.example.Spotify_sample.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Spotify_sample.models.Genres;
import com.example.Spotify_sample.repositories.GenresRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class GenresController {
    
    @Autowired
    GenresRepository genresRepository;

    @GetMapping("/getGenres")
    public List<Genres> getGenres(){
        return genresRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/genres/id")
    public List<Genres> findGenreIdByName(@RequestParam String genre_name){
        return genresRepository.findByName(genre_name).get();
    }

    @GetMapping("/genres/name")
    public Genres findGenreNameById(@RequestParam int genre_id){
        return genresRepository.findById(genre_id).get();
    }

    @GetMapping("/genres/id/{genre_id}")
    public Genres getGenreName(@PathVariable int genre_id){
        return genresRepository.findById(genre_id).get();
    }

    @GetMapping("/genres/name/{genre_name}")
    public List<Genres> searchByName(@PathVariable String genre_name){
        List<Genres> genres = genresRepository.findByName(genre_name).get();
        if(genres.size() > 0) {
            return genres;
        }
        return genresRepository.findAll();
    }


}
