package Buttons;

import java.awt.event.*;
import MovieUI.MovieDB;

public class MovieClearAllListener implements ActionListener {

    public MovieClearAllListener() {
    }

    // resets database with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        db.reset();
    }
}