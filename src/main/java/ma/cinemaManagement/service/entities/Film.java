package ma.cinemaManagement.service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ProjectionFilm> projectionFilms;

    @ManyToOne
    @JoinColumn(name = "categoryFk")
    private Category category;
}
