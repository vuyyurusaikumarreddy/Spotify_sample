package com.example.Spotify_sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.Spotify_sample.models.Albums;

@RepositoryRestResource
@Repository
public interface AlbumsRepository extends JpaRepository<Albums, String>{

    // @Query("SELECT DISTINCT a FROM Albums a JOIN Tracks t ON a.id = t.album_id JOIN PlaylistTrack pt ON t.id = pt.track_id JOIN Playlists pl ON pt.playlist_id = pl.id JOIN GenreSubgenre gs ON pl.playlist_info = gs.id JOIN Genres g ON gs.genre_id = g.id WHERE g.name = 'pop'")
    // @Query("SELECT DISTINCT a FROM Albums a " +
    //         "JOIN Track t ON a.id = t.album.id " +
    //         "JOIN PlaylistTrack pt ON t.id = pt.track.id " +
    //         "JOIN Playlist pl ON pt.playlist.id = pl.id " +
    //         "JOIN GenreSubgenre gs ON pl.playlistInfo.id = gs.id " +
    //         "JOIN Genre g ON gs.genre.id = g.id " +
    //         "WHERE g.name = :genreName")
    // @Query("SELECT a FROM Albums a JOIN Tracks t ON a.id = t.album_id JOIN PlaylistTrack pt ON t.id = pt.track_id JOIN Playlist p ON pt.playlist_id = p.id JOIN GenreSubgenre gs ON p.playlist_Info = gs.id JOIN Genre g ON gs.genre.id = g.id WHERE g.name = :genreName GROUP BY a.name, g.name")
    // Optional<List<Albums>> findAlbumsByGenreName(@Param("genreName") String genreName);

    // @Query("SELECT a FROM Albums a " +
    //    "JOIN Tracks t ON a.id = t.album_id " +
    //    "JOIN PlaylistTrack pt ON t.id = pt.track_id " +
    //    "JOIN Playlist p ON pt.playlist_id = p.id " +
    //    "JOIN GenreSubgenre gs ON p.playlist_Info = gs.id " +
    //    "JOIN Genre g ON gs.genre.id = g.id " +
    //    "WHERE g.name = :genreName " +
    //    "GROUP BY a.id, a.name, g.name")
    // Optional<List<Albums>> findAlbumsByGenreName(@Param("genreName") String genreName);

    
    
}
