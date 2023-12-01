// package com.example.Spotify_sample.models;


// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.PrimaryKeyJoinColumn;
// import jakarta.persistence.Table;
// import lombok.Data;

// @Data
// @Entity
// @Table(name = "genre_subgenre")
// public class GenreSubgenre {

//     @Id
//     @GeneratedValue(strategy=GenerationType.AUTO)
//     @Column(name = "id")
//     private Integer id;
    
//     @OneToOne
//     // @JoinColumn(name = "id", nullable = false)
//     @PrimaryKeyJoinColumn(name = "genre_id")
//     private Genres genreId;

//     @OneToOne
//     @PrimaryKeyJoinColumn(name = "subgenre_id")
//     // @JoinColumn(name = "id")
//     private SubGenres subGenreId;

// }
package com.example.Spotify_sample.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "genre_subgenre")
public class GenreSubgenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genres genre;

    @ManyToOne
    @JoinColumn(name = "subgenre_id")
    private SubGenres subGenre;
}
