package com.example.Spotify_sample.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class PlaylistTrack {

    @Id
    @Column(name = "id")
    private String id;

    @OneToOne
    @JoinColumn(name = "playlist_id")
    private Playlists playlistId;
    
    @OneToOne
    @JoinColumn(name = "track_id")
    private Tracks trackId;

}
