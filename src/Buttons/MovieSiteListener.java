package Buttons;

import java.awt.event.*;
import MovieUI.MovieDB;

public class MovieSiteListener implements ActionListener {

    public MovieSiteListener() { }

    // opens letterboxd site with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        db.letterboxd();
    }
}