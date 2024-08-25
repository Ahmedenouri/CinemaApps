package ma.cinemaManagement.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tblFilm")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFilm")
    private Long idFilm;
    @Column(name = "titreFilm",length = 30)
    private String titreFilm;
    @Column(name = "durationFilm")
    private double durationFilm;
    @Column(name = "directorFilm",length = 30)
    private String directorFilm;
    @Column(name = "descriptionFilm",length = 30)
    private String descriptionFilm;
    @Column(name = "photoFilm")
    private String photoFilm;
    @Column(name = "releaseDate")
    private Date releaseDate;

    @OneToMany(mappedBy = "film")
    private Set<ProjectionFilm> projectionFilmSet;

    @ManyToOne
    @JoinColumn(name = "categoryFk")
    private Category category;
}
