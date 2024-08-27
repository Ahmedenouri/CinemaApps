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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Cinema> cinemas;
}
