package ma.cinemaManagement.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import ma.cinemaManagement.repositories.IFilmRepository;
import ma.cinemaManagement.repositories.ITicketRepository;
import ma.cinemaManagement.service.entities.Film;
import ma.cinemaManagement.service.entities.Ticket;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CinemaRestController {

    private IFilmRepository iFilmRepository;
    private ITicketRepository iTicketRepository;

    @GetMapping(path="/imageFilm/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
    public byte[] uploadImage(@PathVariable (name="id")Long id)  throws IOException{
        Film film=iFilmRepository.findById(id).get();
        String nameImage=film.getPhotoFilm();
        File file=new File(System.getProperty("user.home")+"/cinema/imageFilms/"+nameImage);
        Path path=Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
    @PostMapping(path="/payerTickets")
    @Transactional
    public List<Ticket> payerTickets(@RequestBody TicketBody ticketBody)
    {  List<Ticket> listTickets= new ArrayList<Ticket>();
        ticketBody.getListTickets().forEach(idTicket->{
            Ticket ticket=iTicketRepository.findById(idTicket).get();
            ticket.setNameClientTicket(ticketBody.getNameClient());
            ticket.setReservationTicket(true);
            ticket.setCodePaymentTicket(ticketBody.getCodePayement());
            iTicketRepository.save(ticket);
            listTickets.add(ticket);

        });
        return listTickets;
    }
}
@Data
class TicketBody{
    @JsonProperty("name")
    private String nameClient;
    @JsonProperty("reservation")
    private boolean reservationTicket;
    @JsonProperty("code payement")
    private Integer codePayement;
    @JsonProperty("tickets")
    private List<Long> listTickets=new ArrayList<Long>();
}
