package ma.cinemaManagement.service.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

@Projection(name ="p1",types = {ma.cinemaManagement.service.entities.ProjectionFilm.class})
public interface ProjectionProj {

    Long getIdProjectionFilm();
    double getPriceProjectionFilm();
    Date getDateProjectionFilm();

    Salle getSalle();
    Film getFilm();

    Seance getSeance();
    Collection<Ticket> getTickets();


}
