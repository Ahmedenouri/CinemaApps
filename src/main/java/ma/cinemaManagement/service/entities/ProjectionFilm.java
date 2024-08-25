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
@Entity(name = "tblProjectionFilm")
public class ProjectionFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProjectionFilm")
    private Long idProjectionFilm;
    @Column(name = "dateProjectionFilm")
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
    private Set<Ticket> ticketSet;

    @ManyToOne
    @JoinColumn(name = "seanceFk")
    private Seance seance;
}
