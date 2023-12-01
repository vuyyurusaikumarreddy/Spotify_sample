package com.example.Spotify_sample.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class PlaylistTrack {

    @Id
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlists playlistId;
    
    @ManyToOne
    @JoinColumn(name = "track_id")
    private Tracks trackId;

}
