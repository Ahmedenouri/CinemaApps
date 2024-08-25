package ma.cinemaManagement.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tblVille")
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVille")
    private long idVille;
    @Column(name = "nameVille",length = 30)
    private String nameVille;
    @Column(name = "longitudeVille")
    private double longitudeVille;
    @Column(name = "latitudeVille")
    private double latitudeVille;
    @Column(name = "altitudeVille")
    private double altitudeVille;

    @OneToMany(mappedBy = "ville")
    private Set<Cinema> cinemaSet;
}
