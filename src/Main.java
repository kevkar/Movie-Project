import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        Movie animalHouse = new Movie("Animal House",109,1978);
        Movie caddyshack = new Movie("Caddyshack",98,1980);
        Movie alien = new Movie("Alien", 117,1979);
        Movie eternalSunshineOfTheSpotlessMind = new Movie("Eternal Sunshine of the Spotless Mind",108,2004);

        MovieDB database = new MovieDB();

        database.addMovie(eternalSunshineOfTheSpotlessMind);
        database.addMovie(animalHouse);
        database.addMovie(caddyshack);
        database.addMovie(alien);


        int input = -1;

        while (input != 0) {
            System.out.println("What would you like to do?");
            printMenu();
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    database.addMovie(newMovie());
                    database.sortMovies();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    System.out.println(database);
                    break;
                case 5:
                    break;
                case 0:
                    break;



            }

        }
    }

    public static Movie newMovie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What movie would you like to add?");
        String name = scanner.nextLine();
        System.out.println("What is the movie's length?");
        int length = Integer.parseInt(scanner.next());

        Movie movie = new Movie(name,length);
        return movie;
    }

    public static String removedMovie() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What movie would you like to remove?");
        String movie = scanner.nextLine();
        return movie;
    }

    public static void printMenu() {
        System.out.println("1. add a movie");
        System.out.println("2. remove a movie");
        System.out.println("3. pick a random movie");
        System.out.println("4. view all movies");
        System.out.println("5. delete all movies");
        System.out.println("0. exit");
    }
}
