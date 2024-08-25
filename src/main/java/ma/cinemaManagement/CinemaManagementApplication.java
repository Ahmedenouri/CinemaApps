package ma.cinemaManagement;

import lombok.AllArgsConstructor;
import ma.cinemaManagement.service.ICinemaInitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class CinemaManagementApplication implements CommandLineRunner {
	private final ICinemaInitService iCinemaInitService;
	public static void main(String[] args) {
		SpringApplication.run(CinemaManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
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
