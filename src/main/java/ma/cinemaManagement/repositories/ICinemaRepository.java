package ma.cinemaManagement.repositories;

import ma.cinemaManagement.service.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICinemaRepository extends JpaRepository<Cinema,Long> {
}
