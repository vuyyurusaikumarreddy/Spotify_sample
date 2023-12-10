package com.example.Spotify_sample.models;

import lombok.Data;

@Data
public class PlaylistTracksNames {
    

    private String playlist_name;

    private String track_name;

    public PlaylistTracksNames(String track_name, String playlist_name) {
        this.track_name = track_name;
        this.playlist_name = playlist_name;
    }

}
