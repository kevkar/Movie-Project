package Buttons;

import java.awt.event.*;
import MovieUI.MovieDB;

public class RandomMovieListener implements ActionListener {

    public RandomMovieListener() {
    }

    // shows random movie with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        db.printRandomMovie();
    }
}