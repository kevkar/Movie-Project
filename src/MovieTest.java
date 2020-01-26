import java.io.IOException;
import java.util.ArrayList;

public class MovieTest {
    private MovieDB testDB = new MovieDB();

    public MovieTest() {    }


    public void addMovieTest() {
        System.out.println("Adding five movies to DB: ");
        addMovies(testDB);
        System.out.println("Testing movie of length 0:");
        testDB.addMovie(new Movie("The Artist",0));
        System.out.println("Testing movie of length 600: ");
        testDB.addMovie(new Movie("Shoah",600));
        System.out.println("Testing movie without a name: ");
        testDB.addMovie(new Movie("",85));
        System.out.println("Printing database: ");

    }

    public void removeMovieTest() {
        addMovies(testDB);
        testDB.removeMovie("Titanic");
        System.out.println("With movie removed: ");
        System.out.println(testDB);

    }

    public void sortMovieTest() {
        addMovies(testDB);
        System.out.println("List of movies after sorting: ");
        testDB.sortMovies();
        System.out.println(testDB);
    }

    public void randomTest() {
        addMovies(testDB);
        System.out.println("Five random movies: ");
        for (int i = 0; i < 5; i++) {
            System.out.println(testDB.randomMovie());
        }
    }

    public void movieSiteTest() throws IOException {
        addMovies(testDB);
        ArrayList<Movie> movies = testDB.getMovieList();
        System.out.println("Opening letterboxd for first three movies in database...");
        for (int i = 0; i < 3; i++) {
            Movie movieOpenned = movies.get(i);
            movieOpenned.openMovieSite(movieOpenned);
        }
    }

    public void removeAllTest() {
        addMovies(testDB);
        System.out.println("Removing all movies: ");
        testDB.reset();
        System.out.println("Printing DB: ");
        System.out.println(testDB);
        System.out.println("Adding one movie: ");
        testDB.addMovie(new Movie("Hobo",145));
        System.out.println("Printing database: ");
        System.out.println(testDB);

    }

    public void addMovies(MovieDB testDB) {
        testDB.addMovie(new Movie("Eternal Sunshine of the Spotless Mind",141));
        testDB.addMovie(new Movie("Caddy Shack", 98));
        testDB.addMovie(new Movie("Animal House",89));
        testDB.addMovie(new Movie("Alien",36));
        testDB.addMovie(new Movie("Titanic",67));
        testDB.addMovie(new Movie("Lost",120));
        System.out.println("List of movies: ");
        System.out.println(testDB);
    }




}
