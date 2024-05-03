package com.example.Spotify_sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Spotify_sample.models.PlaylistTrack;

@Repository
public interface PlaylistTracksRepository  extends JpaRepository<PlaylistTrack, Integer>{
    
}
