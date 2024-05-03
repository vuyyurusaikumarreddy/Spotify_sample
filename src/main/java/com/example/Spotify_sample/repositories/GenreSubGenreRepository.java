package com.example.Spotify_sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Spotify_sample.models.GenreSubgenre;


@Repository
public interface GenreSubGenreRepository extends JpaRepository<GenreSubgenre, Integer>{

    public GenreSubgenre findByGenreId(Integer id);
    
    @Query("select gs from GenreSubgenre gs where gs.id=2")
    public GenreSubgenre findByGenre(Integer id);

    @Query(value = "select gs.id from genre_subgenre gs where gs.genre_id = :genre_id and gs.subgenre_id = :subgenre_id", nativeQuery = true)
    public int findIdByGenreAndSubGenre(int genre_id, int subgenre_id);

    @Modifying
    @Transactional
    @Query(value = "insert into genre_subgenre(genre_id, subgenre_id) values(:genre_id, :subgenre_id)", nativeQuery = true)
    public void insertGenreSubgenre(int genre_id, int subgenre_id);

}
