package com.example.Spotify_sample.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tracks {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "artist")
    private String artist;

    
    @Column(name = "popularity")
    private int popularity;

    
    @Column(name = "danceability")
    private float danceability;

    
    @Column(name = "energy")
    private float energy;

    
    @Column(name = "key")
    private int key;

    
    @Column(name = "loudness")
    private float loudness;

    
    @Column(name = "mode")
    private int mode;

    
    @Column(name = "speechiness")
    private float speechiness;

    
    @Column(name = "acousticness")
    private float acousticness;

    
    @Column(name = "instrumentalness")
    private float instrumentalness;

    
    @Column(name = "liveness")
    private float liveness;

    
    @Column(name = "valence")
    private float valence;

    
    @Column(name = "tempo")
    private float tempo;

    
    @Column(name = "duration")
    private int duration;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Albums album_id;

    public Tracks() {

    }
    
    public Tracks(String id, String name, String artist, Albums album_id) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.album_id = album_id;
    }
}
