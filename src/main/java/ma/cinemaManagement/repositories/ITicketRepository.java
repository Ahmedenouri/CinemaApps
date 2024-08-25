package ma.cinemaManagement.repositories;

import ma.cinemaManagement.service.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket,Long> {
}
