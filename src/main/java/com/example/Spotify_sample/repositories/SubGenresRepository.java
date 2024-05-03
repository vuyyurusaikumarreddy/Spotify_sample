package com.example.Spotify_sample.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Spotify_sample.models.SubGenres;

@Repository
public interface SubGenresRepository extends JpaRepository<SubGenres, Integer>{
    
    @Query("SELECT s FROM SubGenres s WHERE s.name LIKE %:name%")
    public Optional<List<SubGenres>> findByName(String name);

    @Query(value = "SELECT name from subgenres", nativeQuery = true)
    public List<String> findNames();
    
}
