package com.example.Spotify_sample.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.Spotify_sample.models.Genres;

@RepositoryRestResource
@Repository
public interface GenresRepository extends JpaRepository<Genres, Integer>{

    // public Optional<Genres> findByName(String name);
    public Optional<Genres> findByName(String name);
    
    
}
