package pl.filmofil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.filmofil.exceptions.NotFoundMovieException;
import pl.filmofil.model.Movie;
import pl.filmofil.model.MovieGenre;
import pl.filmofil.repository.MovieRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MoviesService {

    private final MovieRepository movieRepository;

    @Autowired
    public MoviesService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }

    public Movie findMovieByName(String name){
        return movieRepository.findByName(name).orElseThrow(()-> new NotFoundMovieException("Nie znaleziono filmu"));
    }

    public Movie findMovieByMovieGenre(MovieGenre movieGenre){
        return movieRepository.findByMovieGenre(movieGenre).orElseThrow(()-> new NotFoundMovieException("Nie znaleziono filmu"));
    }

    public void updateMovie(Movie movie) {
        movieRepository.save(movie);
    }

}
