package ma.cinemaManagement.repositories;

import ma.cinemaManagement.service.entities.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
public interface ICinemaRepository extends JpaRepository<Cinema,Long> {
}
