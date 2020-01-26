import java.awt.event.*;

public class MovieListListener implements ActionListener {

    public MovieListListener() {
    }

    // prints the database with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        System.out.println(db);
    }
}