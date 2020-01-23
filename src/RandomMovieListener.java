import java.awt.event.*;
import javax.swing.*;

public class RandomMovieListener implements ActionListener {

    private MovieRecord movieRecord;

    public RandomMovieListener(MovieRecord movieRecord) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        System.out.println(db.randomMovie());
    }
}