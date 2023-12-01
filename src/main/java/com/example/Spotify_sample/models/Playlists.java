package com.example.Spotify_sample.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "genre_subgenre")
public class Playlists {
    
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "playlist_id")
    private String playlist_id;

    @Column(name = "playlist_name")
    private String playlist_name;

    @ManyToOne
    @JoinColumn(name = "playlist_info")
    private GenreSubgenre playlist_info;
    
}
