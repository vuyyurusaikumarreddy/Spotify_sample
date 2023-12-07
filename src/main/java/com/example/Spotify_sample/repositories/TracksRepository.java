package com.example.Spotify_sample.repositories;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.example.Spotify_sample.models.Tracks;

@Repository
@RepositoryRestResource
public interface TracksRepository extends JpaRepository<Tracks, String>{
    
    // @Query(value = "select t.id, t.name, t.artist, t.album_id, t.acousticness, t.loudness, t.mode, t.popularity, t.speechiness, t.danceability, t.duration, t.valence, t.tempo, t.energy, t.instrumentalness, t.key, t.liveness from Tracks t, Albums a where t.album_id = a.id and a.name LIKE %:artistName%", nativeQuery = true)
    @Query(value = "SELECT t.id as id, t.name as name, t.artist as artist FROM Tracks t WHERE t.artist LIKE %:artistName%")
    // @Query(value = "select t.id, t.name, t.artist, t.album_id from Tracks t, Albums a where t.album_id = a.id and a.name LIKE %:artistName%", nativeQuery = true)
    // @Query("SELECT t FROM Tracks t JOIN t.album a WHERE a.name LIKE %:artistName%")
    public Optional<List<Map<String, Object>>> findByArtists(String artistName);

    @Query(value = "SELECT album, STRING_AGG(tracks, ',&& ') AS tracks FROM (SELECT t.name as tracks, a.name as album from Tracks t, Albums a where t.album_id = a.id and a.name LIKE %:album_name% group by tracks, album order by a.name) GROUP BY album", nativeQuery = true)
    public Optional<List<Map<String, Object>>> findByAlbum(String album_name);

    @Query(value = "SELECT * from tracks where name=:track_name", nativeQuery = true)
    public Optional<List<Tracks>> findByName(String track_name);

    @Query(value = "select name from tracks where name LIKE %:track_name%", nativeQuery = true)
    public Optional<List<String>> findByNameParam(String track_name);

    @Query(value = "SELECT name from tracks", nativeQuery = true)
    public List<String> findNames();

    


}
