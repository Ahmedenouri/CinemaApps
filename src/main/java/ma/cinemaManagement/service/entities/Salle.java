package ma.cinemaManagement.service.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tblSalle")
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSale")
    private Long idSalle;
    @Column(name = "nameSalle",length = 30)
    private String nameSalle;
    @Column(name = "numberPlaceSalle")
    private int numberPlaceSalle;

    @ManyToOne
    @JoinColumn(name = "cinemaFk")
    private Cinema cinema;

    @OneToMany(mappedBy = "salle")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Place> places;

    @OneToMany(mappedBy = "salle")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<ProjectionFilm> projectionFilms;
}
