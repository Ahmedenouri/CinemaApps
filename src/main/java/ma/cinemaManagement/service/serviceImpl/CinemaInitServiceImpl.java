package ma.cinemaManagement.service.serviceImpl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.cinemaManagement.repositories.*;
import ma.cinemaManagement.service.ICinemaInitService;
import ma.cinemaManagement.service.entities.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;


@Service
@AllArgsConstructor
@Transactional
@Slf4j
public class CinemaInitServiceImpl implements ICinemaInitService {
    private IVilleRepository iVilleRepository;
    private ICinemaRepository iCinemaRepository;
    private ISalleRepository iSalleRepository;
    private IPlaceRepository iPlaceRepository;
    private ISeanceRepository iSeanceRepository;
    private ICategoryRepository iCategoryRepository;
    private IFilmRepository iFilmRepository;
    private IProjectionFilmRepository iProjectionFilmRepository;
    private ITicketRepository iTicketRepository;

    @Override
    public void initVilles() {
        log.debug("STARTING SAVA DATA");
            Stream.of("Rabat","Casablanca","Marrakech","Tanger").forEach(nameVille->{
            Ville ville =new Ville();
            ville.setNameVille(nameVille);
            iVilleRepository.save(ville);
        });
        log.debug("SAVE DATA SUCCESSFULLY");
    }

    @Override
    public void initCinemas() {
        iVilleRepository.findAll().forEach(ville->{
            Stream.of("Megarama "+ville.getNameVille(),"Daoulize "+ville.getNameVille(),"Renaissance "+ville.getNameVille()).forEach(
                    nameCinema->{
                        Cinema cinema=new Cinema();
                        cinema.setNameCinema(nameCinema);
                        cinema.setNumberSalleCinema(3+(int)(Math.random()*7));
                        cinema.setVille(ville);
                        iCinemaRepository.save(cinema);
                    });
        });
    }

    @Override
    public void initSalles() {
        iCinemaRepository.findAll().forEach(cinema ->{
            IntStream.range(0,cinema.getNumberSalleCinema()).forEach(i->{
                        Salle salle = new Salle();
                        salle.setNameSalle(" salle "+i+1);
                        salle.setCinema(cinema);
                        salle.setNumberPlaceSalle(15+(int)(Math.random()*20));
                iSalleRepository.save(salle);
                    }
);
        });
    }

    @Override
    public void initPlaces() {
        iSalleRepository.findAll().forEach(salle->{
            IntStream.range(0,salle.getNumberPlaceSalle()).forEach(i->{
                        Place place = new Place();
                        place.setNumberPlace(i+1);
                        place.setSalle(salle);
                iPlaceRepository.save(place);
                    }
            );
        });
    }
    @Override
    public void initSeances() {
        DateFormat dateFormat=new SimpleDateFormat("HH:mm");

        Stream.of("12:00","15:00","17:00","19:00","21:00").forEach(s->{
            Seance seance=new Seance();
            try {
                seance.setTimeDebutSeance(dateFormat.parse(s));
                iSeanceRepository.save(seance);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
    }

    @Override
    public void initCategories() {
        Stream.of("Action","Drama","Fiction","Histoire","Horror","Documentary","Comedy","Romantic comedy","Comedy-drama").forEach(cat->{
            Category category=new Category();
            category.setNameCategory(cat);
            iCategoryRepository.save(category);
        });
    }

    @Override
    public void initFilms() {
        double[] duree=new double[]{1,1.5,2,2.5,3};
        List<Category> categories=iCategoryRepository.findAll();
        Stream.of("Twisters","Pet Sematary","Game Of Thrones","Spider Man","Batman","Titanic","Sting","BreakingBad").forEach(nameFilm->{
            Film  film =new Film();
            film.setTitreFilm(nameFilm);
            film.setDurationFilm(duree[(int) (Math.random() * duree.length)]);
            film.setPhotoFilm(nameFilm.replaceAll(" ", "")+".jpg");
            film.setCategory(categories.get(new Random().nextInt(categories.size())));
            iFilmRepository.save(film);
        });
    }

    @Override
    @Transactional
    public void initProjections() {
        double[] prices = new double[] {30,40,50,60,70,80,90,100};
        iVilleRepository.findAll().forEach(nameVille ->{
            nameVille.getCinemas().forEach(nameCinema ->{
                nameCinema.getSalles().forEach(nameSalle ->{
                    iFilmRepository.findAll().forEach(nameFilm ->{
                        iSeanceRepository.findAll().forEach( nameSeance ->{
                            ProjectionFilm projectionFilm = new ProjectionFilm();
                            projectionFilm.setDateProjectionFilm(new Date());
                            projectionFilm.setFilm(nameFilm);
                            projectionFilm.setPriceProjectionFilm(prices[new Random().nextInt(prices.length)]);
                            projectionFilm.setSalle(nameSalle);
                            projectionFilm.setSeance(nameSeance);
                            iProjectionFilmRepository.save(projectionFilm);
                        });
                    });
                });
            });
        });
    }

    @Override
    public void initTickets() {
        iProjectionFilmRepository.findAll().forEach(projection->{
            projection.getSalle().getPlaces().forEach(place->{
                Ticket ticket=new Ticket();
                ticket.setPlace(place);
                ticket.setProjectionFilm(projection);
                ticket.setPriceTicket(projection.getPriceProjectionFilm());
                ticket.setReservationTicket(false);
                iTicketRepository.save(ticket);
            });
        });
    }
}
