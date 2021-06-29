package pl.filmofil.exceptions;

public class NotFoundMovieException extends RuntimeException {
    public NotFoundMovieException(String message){
        super(message);
    }
}
