package ma.cinemaManagement.service.entities;

import jakarta.persistence.Column;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ticketProj",types = Ticket.class)
public interface TicketProjection {
    Long getIdTicket();

    String getNameClientTicket();
    double getPriceTicket();
    Integer getCodePaymentTicket();
    boolean getReservationTicket();
    Place getPlace();
}
