package ch3.action;

import com.opensymphony.xwork2.ActionSupport;
import ch3.model.MovieDto;

import java.util.ArrayList;
import java.util.List;

public class MovieRankAction extends ActionSupport {

    final private List<MovieDto> movies= new ArrayList<>();

    public MovieRankAction() {
        this.movies.add(new MovieDto("no1", "Die Hard", 4));
        this.movies.add(new MovieDto("no2", "Harry Potter", 2));
        this.movies.add(new MovieDto("no23", "Parasite", 5));
        this.movies.add(new MovieDto("no1432", "Mill", 1));
    }

    public List<MovieDto> getMovies() {
        return movies;
    }
}
