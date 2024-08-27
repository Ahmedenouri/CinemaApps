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
@Entity(name = "tblProjectionFilm")
public class ProjectionFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProjectionFilm")
    private Long idProjectionFilm;
    @Column(name = "dateProjectionFilm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateProjectionFilm;
    @Column(name = "priceProjectionFilm")
    private double priceProjectionFilm;

    @ManyToOne
    @JoinColumn(name = "salleFk")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "filmFk")
    private Film film;

    @OneToMany(mappedBy = "projectionFilm")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "seanceFk")
    private Seance seance;
}
