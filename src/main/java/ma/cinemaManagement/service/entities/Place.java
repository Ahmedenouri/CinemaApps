package ma.cinemaManagement.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tblPlace")
public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPlace")
    private Long idPlace;
    @Column(name = "numberPlace")
    private int numberPlace;
    @Column(name = "longitudePlace")
    private double longitudePlace;
    @Column(name = "latitudePlace")
    private double latitudePlace;
    @Column(name = "altitudePlace")
    private double altitudePlace;

    @ManyToOne
    @JoinColumn(name = "salleFk")
    private Salle salle;

    @OneToMany(mappedBy = "place")
    private Set<Ticket> ticketSet;
}
