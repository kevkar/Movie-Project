public class Movie implements Comparable<Movie>{

    private String name;
    private int length;
    private int year;

    public Movie(String name, int length, int year) {
        this.name = name;
        this.length = length;
        this.year = year;
    }

    public Movie(String name, int length) {
        this.name = name;
        this.length = length;
        this.year = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }


    public int getYear() {
        return this.year;
    }

    // gets time in 1:31 format rather than 91 minutes format
    public String getRealTime() {
        String realTime = this.getLength() / 60 + ":" + this.length % 60;
        return realTime;
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
