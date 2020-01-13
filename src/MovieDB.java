import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// holds movies in an array list
public class MovieDB {
    private ArrayList<Movie> movieList = new ArrayList<>();

    public MovieDB() {

    }

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

    // returns array of movies
    public ArrayList getMovies() {
        return movieList;
    }

    // removes a movie from list with linear search
    public void removeMovie(Movie movie) {
        if (findMovie(movie)) {
            movieList.remove(movie);
            System.out.println("Movie successfully removed");
        }
    }

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
        Collections.sort(movieList);
    }

    // opens corresponding letterboxd search to avoid conflicting titles
    public void openMovieSite(Movie movie) throws IOException {
        String link = "https://letterboxd.com/search/" ;
        link += movie.searchedName();
        java.awt.Desktop.getDesktop().browse(URI.create(link));
    }

    // linear search for movie
    public boolean findMovie(Movie movie) {
        if (movieList.size() > 0) {
            for (int i = 0; i < movieList.size(); i++) {
                if (movieList.get(i).getName().equals(movie.getName())) {
                return true;
                }
            }
        }
        System.out.println("No movies yet!");
        return false;
    }

    public boolean findMovie (String title, int length) {
        for (Movie movie : movieList) {
            if (title.equals(movie.getName()) && movie.getLength() == length) {
                return true;
            }
        }
        return false;
    }

    // picks a random movie
    public Movie randomMovie() {
        Random random = new Random();
        int pick = random.nextInt(movieList.size() -1);
        return movieList.get(pick);
    }

    public void reset() {
        movieList.clear();
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
