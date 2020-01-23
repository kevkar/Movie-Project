import java.awt.event.*;
import java.io.IOException;

public class MovieSiteListener implements ActionListener {

    public MovieSiteListener(MovieRecord movieRecord) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Movie movie = new Movie(MovieRecordListener.nameField().getText());
        try {
            movie.openMovieSite(movie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}