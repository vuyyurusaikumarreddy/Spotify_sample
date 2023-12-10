package com.example.Spotify_sample.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.Spotify_sample.models.Genres;

@RepositoryRestResource
@Repository
public interface GenresRepository extends JpaRepository<Genres, Integer>{

    // public Optional<Genres> findByName(String name);
    // @Query("select g from genres g where g.name like %:name%")
    @Query("SELECT g FROM Genres g WHERE g.name LIKE %:name%")
    public Optional<List<Genres>> findByName(String name);

    @Query(value = "SELECT name from genres", nativeQuery = true)
    public List<String> findNames();
    
    
}
