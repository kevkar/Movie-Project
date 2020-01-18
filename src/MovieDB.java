import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// holds movies in an array list
public class MovieDB {
    private ArrayList<Movie> movieList = new ArrayList<>();

    public MovieDB() {};

    // adds movies to the array list
    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    // prints out all movies in db
    @Override
    public String toString() {
        String theMovies = "";
        for (Movie movie: movieList) {
            theMovies += movie +"\n";
        }
        return theMovies;
    }

    // removes a movie from list with linear search
    public void removeMovie(String title) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(title)) {
                movieList.remove(movie);
                System.out.println("Movie successfully removed");
                break;
            }
        }
    }

    // sorts movies by length using comparable
    public void sortMovies() {
        if (movieList.size() > 0) {
            Collections.sort(movieList);
        } else {
            System.out.println("No movies to sort!");
        }
    }

    // opens corresponding letterboxd search to avoid conflicting titles
    public void openMovieSite(Movie movie) throws IOException {
        String link = "https://letterboxd.com/search/" ;
        link += movie.searchedName();
        java.awt.Desktop.getDesktop().browse(URI.create(link));
    }

    // picks a random movie
    public Movie randomMovie() {
        Random random = new Random();
        int pick = random.nextInt(movieList.size() -1);
        return movieList.get(pick);
    }

    // clears the entire movie list
    public void reset() { movieList.clear();
    }

    public Movie findMovie(String title) {
        for(Movie movie : movieList) {
            if (title.equals(movie.getName())) {
                return movie;
            }
        }
        return null;
    }

}
