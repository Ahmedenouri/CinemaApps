package ma.cinemaManagement.service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tblTicket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTicket")
    private Long idTicket;
    @Column(name = "nameClientTicket",length = 30)
    private String nameClientTicket;
    @Column(name = "priceTicket")
    private double priceTicket;
    @Column(name = "codePaymentTicket",unique = true,nullable = true)
    private Integer codePaymentTicket;
    @Column(name = "reservationTicket")
    private boolean reservationTicket;

    @ManyToOne
    @JoinColumn(name = "placeFk")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "projectionFilmFk")
    private ProjectionFilm projectionFilm;
}
