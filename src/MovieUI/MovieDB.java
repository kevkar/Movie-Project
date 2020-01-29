package MovieUI;

import Buttons.MovieRecordListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// holds movies in an array list
public class MovieDB {
    private ArrayList<Movie> movieList = new ArrayList<>();

    public MovieDB() {};

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    // adds movies to the array list
    public void addMovie(Movie movie) {
        if (movieDuplicate(movie.getName())) {
            System.out.println("Movie " + '"' + movie.getName() + '"' + " already in database.");
        } else if (movie.getLength() > 400) {
            System.out.println("Why are you trying to watch a 6 hour movie c'mon.");
        } else if(movie.getLength() < 5) {
            System.out.println("That is not a real length");
        } else if (movie.getName().equals("")) {
            System.out.println("You forgot to enter a movie");
        } else {
            movieList.add(movie);
            System.out.println("Movie " + '"' + movie.getName() + '"' + " successfully added.");
        }
    }

    //adds movies using the text fields for the GUI and sorts movies
    public void addMovieGUI() {
        String text = MovieRecordListener.nameField().getText();

        if (text.isEmpty()) {
            System.out.println("That is not a movie.");
        } else {
            try {
                int length = Integer.parseInt(MovieRecordListener.IDField().getText());
                Movie movie = new Movie(text, length);

                addMovie(movie);
            } catch (Exception e) {
                if (MovieRecordListener.IDField().getText().equals("")) {
                    System.out.println("Please enter length.");
                } else {
                    System.out.println("Invalid Movie");
                }
            }
        }
        sortMovies();
    }

    // prints out all movies in db
    @Override
    public String toString() {
        if (movieList.isEmpty()) {
            return "No movies to show.";
        }
        String theMovies = "";
        for (Movie movie: movieList) {
            theMovies += movie +"\n";
        }
        return theMovies;
    }

    // removes a movie from list with linear search
    public boolean removeMovie(String title) {
        for (Movie movie : movieList) {
            if (movie.getName().equals(title)) {
                movieList.remove(movie);
                System.out.println("MMovie " + '"' + title + '"' + " successfully removed.");
                return true;
            }
        }
        System.out.println("Movie not found");
        return true;
    }

    // sorts movies by length using comparable
    public boolean sortMovies() {
        if (movieList.size() > 0) {
            Collections.sort(movieList);
            return true;
        }
        return false;
    }

    // picks a random movie
    public Movie randomMovie() {
        Random random = new Random();
            int pick = random.nextInt(movieList.size() );
            return movieList.get(pick);
    }

    // prints the random movie
    public void printRandomMovie() {
        if (getMovieList().isEmpty()) {
            System.out.println("Movie database is empty!");
        } else {
            System.out.println("Random movie: " + randomMovie());
        }
    }

    // clears the entire movie list
    public void reset() {
        if (movieList.isEmpty()) {
            System.out.println("There are no movies what are you doing");
        } else {
            movieList.clear();
            System.out.println("Movie database successfully cleared.");
        }
    }

    // checks for duplicate movie
    public boolean movieDuplicate(String title) {
        for (Movie movie : movieList) {
            if (title.equals(movie.getName())) {
                return true;
            }
        }
        return false;
    }

    //searches movie on letterboxd using GUI
    public void letterboxd() {
        String boxText = MovieRecordListener.nameField().getText();
        if (boxText.isEmpty()) {
            System.out.println("Try typing something first...");
        } else {
            Movie movie = new Movie(boxText,0);
            try {
                movie.openMovieSite(movie);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
