import java.util.Collection;

public interface MovieRecord {

        void record(Movie movie);
        Movie get(String id);

        void delete(Movie movie);
        void delete(String id);
        void deleteAll();

        Collection<Movie> getAll();

}
