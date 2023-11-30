package com.example.Spotify_sample.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
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

    @OneToOne
    @JoinColumn(name = "album_id")
    private Albums album_id;
}
