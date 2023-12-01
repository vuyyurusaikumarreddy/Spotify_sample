package com.example.Spotify_sample.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.Spotify_sample.models.Playlists;

@Repository
@RepositoryRestResource
public interface PlaylistsRepository extends JpaRepository<Playlists, Integer>{

    @Query(value = "select p.id, p.playlist_id, p.playlist_name, p.playlist_info from playlists p, genre_subgenre gs, genres g where p.playlist_info = gs.id and gs.genre_id = g.id and g.name LIKE %:genre_name%", nativeQuery = true)
    public List<Playlists> findByGenre(String genre_name);

    @Query(value = "select p.id, p.playlist_id, p.playlist_name, p.playlist_info from playlists p, genre_subgenre gs, genres g where p.playlist_info = gs.id and gs.genre_id = g.id and g.name LIKE %:subgenre_name%", nativeQuery = true)
    public List<Playlists> findBySubGenre(String subgenre_name);
    
}
