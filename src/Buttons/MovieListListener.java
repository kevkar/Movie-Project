package Buttons;

import java.awt.event.*;
import MovieUI.MovieDB;

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