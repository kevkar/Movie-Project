import java.awt.event.*;
import javax.swing.*;

public class MovieRemoveListener implements ActionListener {

    private MovieRecord movieRecord;

    public MovieRemoveListener(MovieRecord movieRecord) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        String title = MovieRecordListener.nameField().getText();
        db.removeMovie(title);
    }
}