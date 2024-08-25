package ma.cinemaManagement.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tblSeance")
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSeance")
    private Long idSeance;
    @Column(name = "timeDebutSeance")
    @Temporal(TemporalType.TIME)
    private Date timeDebutSeance;
}
