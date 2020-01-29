package MovieUI;

import java.io.IOException;
import java.net.URI;

public class Movie implements Comparable<Movie>{

    private String name;
    private int length;

    // two constructors, one for name and length and one for just name
    public Movie(String name, int length) {
        this.name = name;
        this.length = length;
    }

    // two getters for name and length
    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }

    // gets time in 1:31 format rather than 91 minutes format
    public String getRealTime() {
        String realTime = this.getLength() / 60 + ":" + this.length % 60;
        StringBuilder sb = new StringBuilder(realTime);
        if (this.getLength() % 60 == 0) {
           realTime = sb.append('0').toString();
        }
        if ((this.getLength() % 60) < 10 && ((this.getLength() % 60) > 1)) {
            realTime = sb.insert(2,'0').toString();
        }
        return realTime;
    }


    // replaces spaces with dashes for searching on letterboxd.com
    public String searchedName() {
        return this.name.replace(' ','+');
    }

    // opens corresponding letterboxd search
    // does not open specific movie's site bc of duplicates
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


}
