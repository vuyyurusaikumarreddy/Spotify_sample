package com.example.Spotify_sample.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Spotify_sample.models.Playlists;

@Repository
public interface PlaylistsRepository extends JpaRepository<Playlists, Integer>{

    @Query(value = "select p.id, p.playlist_id, p.playlist_name, p.playlist_info from playlists p, genre_subgenre gs, genres g where p.playlist_info = gs.id and gs.genre_id = g.id and g.name LIKE %:genre_name%", nativeQuery = true)
    public List<Playlists> findByGenre(String genre_name);

    @Query(value = "select p.id, p.playlist_id, p.playlist_name, p.playlist_info from playlists p, genre_subgenre gs, genres g where p.playlist_info = gs.id and gs.genre_id = g.id and g.name LIKE %:subgenre_name%", nativeQuery = true)
    public List<Playlists> findBySubGenre(String subgenre_name);

    @Query(value = "select playlists.playlist_name as name, genres.name as genre, subgenres.name as subgenre from playlists,genres,subgenres,genre_subgenre where playlists.playlist_info = genre_subgenre.id and genre_subgenre.genre_id = genres.id and genre_subgenre.subgenre_id = subgenres.id", nativeQuery = true)
    public List<Map<String, Object>> findBy();

    @Modifying
    @Transactional
    @Query(value = "insert into playlists (playlist_id, playlist_name, playlist_info) values(:playlist_id, :playlist_name, :genre_subgenre_id)", nativeQuery = true)
    public void insertPlaylist(String playlist_id, String playlist_name, int genre_subgenre_id);

    @Query(value = "select p.playlist_name, t.name as track_name from playlists p, tracks t, playlist_track a where t.id = a.track_id and p.id = a.playlist_id and p.playlist_name = :playlistName group by p.playlist_name, t.name order by p.playlist_name", nativeQuery = true)
    public List<Map<String, Object>> findPlaylistsAndTracks(String playlistName);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM playlist_track WHERE playlist_id IN (SELECT id FROM playlists WHERE playlist_name = :playlist_name) AND track_id IN (SELECT id FROM tracks WHERE name = :track_name)", nativeQuery = true)
    public void deleteTrackFromPlaylist(String playlist_name, String track_name);

    @Query(value = "SELECT playlist_name from playlists", nativeQuery = true)
    public List<String> findNames();

    @Query(value = "SELECT insert_into_playlist_track(:playlist_name, :track_name)", nativeQuery = true)
    public void insertTrackToPlaylist(String track_name, String playlist_name);
    
}
