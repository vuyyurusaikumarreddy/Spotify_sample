package com.example.Spotify_sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.Spotify_sample.models.PlaylistTrack;

@RepositoryRestResource
public interface PlaylistTracksRepository  extends JpaRepository<PlaylistTrack, Integer>{
    
}
