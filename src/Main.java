import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {


        Movie animalHouse = new Movie("Animal House",109,1978);
        Movie caddyshack = new Movie("Caddyshack",98,1980);
        Movie alien = new Movie("Alien", 117,1979);

        MovieDB database = new MovieDB();

        database.addMovie(animalHouse);
        database.addMovie(caddyshack);
        database.addMovie(alien);



        System.out.println(database.toString());



//        System.out.println(database.getMovies().get(1));


        //database.removeMovie(caddyshack);


//        String url = "https://www.justwatch.com/us/movie/ninotchka";
//        java.awt.Desktop.getDesktop().browse(URI.create(url));

    }
}
