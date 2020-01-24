import java.awt.event.*;
import java.io.IOException;

public class MovieSiteListener implements ActionListener {

    public MovieSiteListener(MovieRecord movieRecord) { }

    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        db.letterboxd();
    }
}