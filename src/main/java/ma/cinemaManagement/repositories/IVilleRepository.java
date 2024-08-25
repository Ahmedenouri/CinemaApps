package ma.cinemaManagement.repositories;

import ma.cinemaManagement.service.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVilleRepository extends JpaRepository<Ville,Long> {
}
