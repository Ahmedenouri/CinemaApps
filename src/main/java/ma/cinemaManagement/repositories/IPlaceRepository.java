package ma.cinemaManagement.repositories;

import ma.cinemaManagement.service.entities.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlaceRepository extends JpaRepository<Place,Long> {
}
