package com.example.Spotify_sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.Spotify_sample.models.GenreSubgenre;

@RepositoryRestResource
@Repository
public interface GenreSubGenreRepository extends JpaRepository<GenreSubgenre, Integer>{

    public GenreSubgenre findByGenreId(Integer id);
    
    @Query("select gs from GenreSubgenre gs where gs.id=2")
    public GenreSubgenre findByGenre(Integer id);
    
}
