import java.util.ArrayList;


public class MovieDB {
    private ArrayList<Movie> movieList = new ArrayList<>();


    public MovieDB() {

    }

    public void addMovie(Movie movie) {
        movieList.add(movie);
    }

    @Override
    public String toString() {
        String theMovies = "";
        for (Movie movie: movieList) {
            theMovies += movie +"\n";
        }
        return theMovies;
    }

    public ArrayList getMovies() {
        return movieList;
    }

    public void removeMovie(Movie movie) {
        if (movieList.size() > 0) {
            for (int i = 0; i < movieList.size(); i++) {
                if (movieList.get(i).getName().equals(movie.getName())) {
                    movieList.remove(movie);
                } else {
                    System.out.println("No movies yet!");
                }
            }
        }
    }

    public void sortMovies() {
        
    }


}
