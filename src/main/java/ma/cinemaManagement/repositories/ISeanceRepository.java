package ma.cinemaManagement.repositories;

import ma.cinemaManagement.service.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISeanceRepository extends JpaRepository<Seance,Long> {
}
