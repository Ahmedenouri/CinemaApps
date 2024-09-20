package ma.cinemaManagement;

import lombok.AllArgsConstructor;
import ma.cinemaManagement.service.ICinemaInitService;
import ma.cinemaManagement.service.entities.Film;
import ma.cinemaManagement.service.entities.Salle;
import ma.cinemaManagement.service.entities.Ticket;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@AllArgsConstructor
public class CinemaManagementApplication implements CommandLineRunner {
	private final ICinemaInitService iCinemaInitService;
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(CinemaManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Film.class, Salle.class, Ticket.class);
		iCinemaInitService.initVilles();
		iCinemaInitService.initCinemas();
		iCinemaInitService.initSalles();
		iCinemaInitService.initPlaces();
		iCinemaInitService.initSeances();
		iCinemaInitService.initCategories();
		iCinemaInitService.initFilms();
		iCinemaInitService.initProjections();
		iCinemaInitService.initTickets();
	}
}
