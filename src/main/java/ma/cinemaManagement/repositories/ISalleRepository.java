package ma.cinemaManagement.repositories;

import ma.cinemaManagement.service.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISalleRepository extends JpaRepository<Salle,Long> {
}
