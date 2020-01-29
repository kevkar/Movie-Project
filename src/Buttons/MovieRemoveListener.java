package Buttons;

import java.awt.event.*;

import MovieUI.MovieDB;


public class MovieRemoveListener implements ActionListener {

    public MovieRemoveListener() {
    }

    // removes a movie with GUI
    @Override
    public void actionPerformed(ActionEvent ae) {
        MovieDB db = MovieRecordListener.getDB();
        String title = MovieRecordListener.nameField().getText();
        db.removeMovie(title);
    }
}