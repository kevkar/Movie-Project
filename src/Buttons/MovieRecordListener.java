package Buttons;

import java.awt.event.*;
import javax.swing.*;
import MovieUI.*;

public class MovieRecordListener implements ActionListener {

    private static JTextField nameField;
    private static JTextField idField;
    private static MovieDB db = new MovieDB();

    public MovieRecordListener(JTextField nameField, JTextField idField) {
        this.nameField = nameField;
        this.idField = idField;
    }

    public static MovieDB getDB() {
        return db;
    }

    public static JTextField nameField() {
        return nameField;
    }

    public static JTextField IDField() {return idField;}

    @Override
    public void actionPerformed(ActionEvent ae) {
        db.addMovieGUI();
    }
}