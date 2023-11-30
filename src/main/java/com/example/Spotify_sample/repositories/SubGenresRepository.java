package com.example.Spotify_sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.Spotify_sample.models.SubGenres;

@Repository
@RepositoryRestResource
public interface SubGenresRepository extends JpaRepository<SubGenres, Integer>{
    
    
}
