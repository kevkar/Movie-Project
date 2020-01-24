import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private MovieRecord movieRecord;

    public UserInterface(MovieRecord movieRecord) {
        this.movieRecord = movieRecord;
    }

    public UserInterface() {

    }

    @Override
    public void run() {
        frame = new JFrame("Title");
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {

        GridLayout layout = new GridLayout(6, 2);
        container.setLayout(layout);

        JLabel nameText = new JLabel("Movie Name: ");
        JTextField nameField = new JTextField();
        JLabel idText = new JLabel("Movie Length: ");
        JTextField idField = new JTextField();
        JButton removeButton = new JButton("Remove!");
        JButton randomMovieButton = new JButton("Random Movie");
        JButton movieInfoButton = new JButton("Movie info");
        JButton listMovies = new JButton("List Movies");
        JButton clearDB = new JButton("Remove all Movies");

        JButton addButton = new JButton("Add!");
        MovieRecordListener listener = new MovieRecordListener(movieRecord, nameField, idField);
        addButton.addActionListener(listener);
        randomMovieButton.addActionListener(new RandomMovieListener(movieRecord));
        movieInfoButton.addActionListener(new MovieSiteListener(movieRecord));
        removeButton.addActionListener(new MovieRemoveListener(movieRecord));
        listMovies.addActionListener(new MovieListListener(movieRecord));
        clearDB.addActionListener(new MovieClearAllListener(movieRecord));

        container.add(nameText);
        container.add(nameField);
        container.add(idText);
        container.add(idField);
        container.add(removeButton);
        container.add(addButton);
        container.add(new JLabel(" "));
        container.add(new JLabel(" "));
        container.add(randomMovieButton);
        container.add(movieInfoButton);
        container.add(listMovies);
        container.add(clearDB);
    }

    public JFrame getFrame() {
        return frame;
    }
}