import java.io.IOException;
import java.net.URI;

public class Movie implements Comparable<Movie>{

    private String name;
    private int length;

    public Movie(String name, int length) {
        this.name = name;
        this.length = length;
    }

    Movie(String name) {
        this.name = name;
        this.length = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }

    // gets time in 1:31 format rather than 91 minutes format
    public String getRealTime() {
        String realTime = this.getLength() / 60 + ":" + this.length % 60;
        if (this.getLength() % 60 == 0) {
            realTime += '0';
        }
        return realTime;
    }

    // opens corresponding letterboxd search to avoid conflicting titles
    public void openMovieSite(Movie movie) throws IOException {
        String link = "https://letterboxd.com/search/" ;
        link += movie.searchedName();
        java.awt.Desktop.getDesktop().browse(URI.create(link));
    }

    // prints out movie length + movie name
    @Override
    public String toString() {
       return this.getRealTime() + " " + this.getName();
    }

    // compares movies by length
    @Override
    public int compareTo(Movie movie) {
        return this.getRealTime().compareTo(movie.getRealTime());
    }

    // replaces spaces with dashes for searching on letterboxd.com
    public String searchedName() {
        return this.name.replace(' ','+');
    }
}
