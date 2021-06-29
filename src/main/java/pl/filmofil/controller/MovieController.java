package pl.filmofil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.filmofil.model.Movie;
import pl.filmofil.model.MovieGenre;
import pl.filmofil.service.MoviesService;

import java.util.List;

@RestController
@RequestMapping("/filmofil")
public class MovieController {

    private final MoviesService moviesService;

    @Autowired
    public MovieController(MoviesService moviesService) {
        this.moviesService = moviesService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> allMovies = moviesService.findAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewMovie (@RequestBody Movie movie){
        moviesService.addMovie(movie);
    }

    @PostMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMovie (@RequestBody Movie movie){
        moviesService.deleteMovie(movie);
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateMovie (@RequestBody Movie movie){
        moviesService.updateMovie(movie);
    }

    @GetMapping("/find/{movieName}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("movieName") String movieName){
        Movie movie= moviesService.findMovieByName(movieName);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @GetMapping("/movies/{movieGenre}")
    public ResponseEntity<Movie> getMovieByMovieGenre(@PathVariable("movieGenre") String movieGenre){
        Movie movie= moviesService.findMovieByMovieGenre(MovieGenre.valueOf(movieGenre));
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

}
