package repo;

import entities.Movie;
import entities.Seat;

import java.util.HashMap;
import java.util.Map;

public class MovieRepo {
    private Map<String, Movie> movieMap;
    public MovieRepo(){
        movieMap = new HashMap<>();
    }
    public void addMovie(Movie movie){
        movieMap.putIfAbsent(movie.getId(),movie);
    }
    public Movie getMovie(String id){
        return movieMap.get(id);
    }
}
