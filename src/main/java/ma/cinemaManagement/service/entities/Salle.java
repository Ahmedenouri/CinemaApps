package ma.cinemaManagement.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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
    private Set<Place> placeSet;

    @OneToMany(mappedBy = "salle")
    private Set<ProjectionFilm> projectionFilmSet;
}
