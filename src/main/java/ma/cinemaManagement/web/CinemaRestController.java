package ma.cinemaManagement.web;

import lombok.AllArgsConstructor;
import ma.cinemaManagement.repositories.IFilmRepository;
import ma.cinemaManagement.service.entities.Film;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@AllArgsConstructor
public class CinemaRestController {

    private IFilmRepository iFilmRepository;

    @GetMapping(path="/imageFilm/{id}",produces=MediaType.IMAGE_JPEG_VALUE)
    public byte[] uploadImage(@PathVariable (name="id")Long id)  throws IOException{
        Film film=iFilmRepository.findById(id).get();
        String nameImage=film.getPhotoFilm();
        File file=new File(System.getProperty("user.home")+"/cinema/imageFilms/"+nameImage);
        Path path=Paths.get(file.toURI());
        return Files.readAllBytes(path);
    }
}
