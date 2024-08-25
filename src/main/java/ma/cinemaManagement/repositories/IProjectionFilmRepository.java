package ma.cinemaManagement.repositories;

import ma.cinemaManagement.service.entities.ProjectionFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectionFilmRepository extends JpaRepository<ProjectionFilm,Long> {
}
