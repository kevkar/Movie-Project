import java.awt.event.*;

public class RandomMovieListener implements ActionListener {

    public RandomMovieListener() {
    }

    // shows random movie with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        db.printRandomMovie();
    }
}