package ma.cinemaManagement.repositories;

import ma.cinemaManagement.service.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface ITicketRepository extends JpaRepository<Ticket,Long> {
}
