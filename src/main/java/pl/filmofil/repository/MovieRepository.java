package pl.filmofil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.filmofil.model.Movie;
import pl.filmofil.model.MovieGenre;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findByName(String name);

    Optional<Movie> findByMovieGenre(MovieGenre movieGenre);
}
