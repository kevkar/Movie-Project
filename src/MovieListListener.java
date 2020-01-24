import java.awt.event.*;
import javax.swing.*;

public class MovieListListener implements ActionListener {

    private MovieRecord movieRecord;

    public MovieListListener(MovieRecord movieRecord) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        System.out.println(db);
    }
}