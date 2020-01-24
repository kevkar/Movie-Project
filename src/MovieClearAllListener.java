import java.awt.event.*;
import javax.swing.*;

public class MovieClearAllListener implements ActionListener {

    private MovieRecord movieRecord;

    public MovieClearAllListener(MovieRecord movieRecord) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        db.reset();
    }
}