package com.example.Spotify_sample.controllers;

import java.util.List;

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

import com.example.Spotify_sample.models.Genres;
import com.example.Spotify_sample.models.SubGenres;
import com.example.Spotify_sample.repositories.GenreSubGenreRepository;
import com.example.Spotify_sample.repositories.GenresRepository;
import com.example.Spotify_sample.repositories.SubGenresRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000/", allowCredentials = "true")
public class SubGenresController {
    
    @Autowired
    SubGenresRepository subGenresRepository;

    @Autowired
    GenreSubGenreRepository genreSubGenreRepository;

    @Autowired
    GenresRepository genresRepository;

    @GetMapping("/getSubGenres")
    public List<SubGenres> getGenres(){
        return subGenresRepository.findAll();
    }

    /**
     * @param id
     * @return
     */
    @GetMapping("/subgenres/id")
    public String findSubGenreNameById(@RequestParam int genre_id){
        return subGenresRepository.findById(genre_id).get().getName();
    }

    @GetMapping("/subgenres/name")
    public String findSubGenreNameByGenreName(@RequestParam String genre_name){
        Genres genres = genresRepository.findByName(genre_name).get().get(0);
        return genreSubGenreRepository.findByGenreId(genres.getId()).getGenre().getName();
    }

    @PostMapping("/subgenres/insertSubgenre")
    public ResponseEntity<String> insertSubgenres(@RequestBody SubGenres subGenres){
        subGenresRepository.save(subGenres);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Successfully inserted sub genres");
    }
    
    @GetMapping("/subgenres/name/{subgenre_name}")
    public List<SubGenres> searchByName(@PathVariable String subgenre_name){
        List<SubGenres> subGenres = subGenresRepository.findByName(subgenre_name).get();
        if(subGenres.size() > 0) {
            return subGenres;
        }
        return subGenresRepository.findAll();
    }


}
