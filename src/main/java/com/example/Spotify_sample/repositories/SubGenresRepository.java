package com.example.Spotify_sample.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.Spotify_sample.models.SubGenres;

@Repository
@RepositoryRestResource
public interface SubGenresRepository extends JpaRepository<SubGenres, Integer>{
    
    @Query("SELECT s FROM SubGenres s WHERE s.name LIKE %:name%")
    public Optional<List<SubGenres>> findByName(String name);
    
}
