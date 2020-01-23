import java.awt.event.*;
import javax.swing.*;

public class MovieRecordListener implements ActionListener {

    private MovieRecord movieRecord;
    private static JTextField nameField;
    private static JTextField idField;
    private static MovieDB db = new MovieDB();

    public MovieRecordListener(MovieRecord movieRecord, JTextField nameField, JTextField idField) {
        this.movieRecord = movieRecord;
        this.nameField = nameField;
        this.idField = idField;

    }

    public static MovieDB getDB() {
        return db;
    }

    public static JTextField nameField() {
        return nameField;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            Movie movie = new Movie(nameField.getText(), Integer.parseInt(idField.getText()));
            db.addMovie(movie);
        } catch (Exception e) {
            System.out.println("Invalid Movie");
        }

        db.sortMovies();
        System.out.println(db);
    }
}