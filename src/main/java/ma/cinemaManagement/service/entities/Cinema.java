package ma.cinemaManagement.service.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tblCinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCinema")
    private Long idCinema;
    @Column(name = "nameCinema",length = 30)
    @NotNull(message = "please fill in the field name Cinema.")
    private String nameCinema;
    @Column(name = "longitudeCinema")
    private double longitudeCinema;
    @Column(name = "latitudeCinema")
    private double latitudeCinema;
    @Column(name = "altitudeCinema")
    private double altitudeCinema;
    @Column(name = "numberSalleCinema")
    private int numberSalleCinema;

    @OneToMany(mappedBy = "cinema")
    private Collection<Salle> salles;
    @ManyToOne
    @JoinColumn(name = "villeFk")
    private Ville ville;
}
