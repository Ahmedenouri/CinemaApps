package ma.cinemaManagement.repositories;

import ma.cinemaManagement.service.entities.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFilmRepository extends JpaRepository<Film,Long> {
}
