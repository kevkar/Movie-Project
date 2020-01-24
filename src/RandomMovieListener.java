import java.awt.event.*;

public class RandomMovieListener implements ActionListener {

    private MovieRecord movieRecord;

    public RandomMovieListener(MovieRecord movieRecord) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        db.printRandomMovie();
    }
}