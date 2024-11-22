package formtest.model;

public class MovieDto {

    final private String movieId;
    final private String movieName;
    final private int movieStars;

    public MovieDto(String movieId, String movieName, int movieStars) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieStars = movieStars;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getMovieStars() {
        return movieStars;
    }

}
