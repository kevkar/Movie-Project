import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        MovieDB database = new MovieDB();

        database.addMovie( new Movie("Eternal Sunshine of the Spotless Mind",108,2004));
        database.addMovie(new Movie("Animal House",109,1978));
        database.addMovie(new Movie("Caddyshack",98,1980));
        database.addMovie(new Movie("Alien", 117,1979));

        int input = -1;

        while (input != 0) {
            System.out.println("What would you like to do?");
            printMenu();
            input = scanner.nextInt();
            switch (input) {
                case 1:
                    addMovieToDB(database, movieAdded());
                    break;
                case 2:
                    removeMovie(database);
                    break;
                case 3:
                    getRandomMovie(database);
                    break;
                case 4:
                    printDB(database);
                    break;
                case 5:
                    deleteAll(database);
                    break;
                case 6:
                    openSite(database);
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println();
        System.out.println("1. Add a movie");
        System.out.println("2. Remove a movie");
        System.out.println("3. Pick a random movie");
        System.out.println("4. List all movies");
        System.out.println("5. Delete all movies");
        System.out.println("6. Open movie website");
        System.out.println("0. Exit");
    }

    public static void addMovieToDB(MovieDB db,Movie movie) {
        db.addMovie(movie);
        db.sortMovies();
    }

    public static Movie movieAdded() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What movie would you like to add?");
        String name = scanner.nextLine();

        System.out.println("What is the movie's length?");
        int length = Integer.parseInt(scanner.next());
        if (length < 1) {
            throw new IllegalArgumentException("Movie length can't be negative or 0!");
        }

        return new Movie(name,length);
    }

    public static void removeMovie(MovieDB db) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What movie would you like to delete?");
        String movieName = scanner.nextLine();

        db.removeMovie(movieName);
    }

    public static void getRandomMovie(MovieDB db) {
        System.out.println(db.randomMovie());
    }

    public static void printDB(MovieDB db) {
        System.out.println(db);;
    }

    public static void deleteAll(MovieDB db) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you sure you want to delete everything?");
        String input = scanner.next();
        if (input == "yes" || input == "y") {
            db.reset();
            System.out.println("Database cleared");
        } else {
            System.out.println("Good idea, better not");
        }
    }

    public static void openSite(MovieDB db) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String title;

        System.out.println("What movie's info would you like to open?");
        title = scanner.nextLine();
        try {
            db.openMovieSite(db.findMovie(title));
        } catch (NullPointerException e) {
            System.out.println("Movie not found!");
        }
    }


}
