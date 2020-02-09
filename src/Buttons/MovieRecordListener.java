package Buttons;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
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

    public static void textFileStuff() throws IOException {
        File file = new File("MovieTestFile");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {

            String nextLine = scanner.nextLine();
            int length = Integer.parseInt(nextLine.substring(0,nextLine.indexOf(" ")));
            String title = nextLine.substring(nextLine.indexOf(" ") + 1);

            getDB().addMovie(new Movie(title,length));

            System.out.println(getDB());
        }

        getDB().clearTextFile();

        getDB().appendMoviesToFile();
    }

    public static JTextField IDField() {return idField;}

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            db.addMovieGUI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}