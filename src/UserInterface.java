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
//        container.setLayout(new BorderLayout());
//
//        container.add(new JButton("North"), BorderLayout.NORTH);
//        container.add(new JButton("East"), BorderLayout.EAST);
//        container.add(new JButton("South"), BorderLayout.SOUTH);
//        container.add(new JButton("West"), BorderLayout.WEST);
//        container.add(new JButton("Center"), BorderLayout.CENTER);
//

//        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
//        container.setLayout(layout);
//
//        container.add(new JLabel("First!"));
//        container.add(new JLabel("Second!"));
//        container.add(new JLabel("Third!"));


//        JButton button = new JButton("Send!");
//        button.addActionListener(new MessageListener());
//
//        container.add(button);


//        GridLayout layout = new GridLayout(1, 3);
//        container.setLayout(layout);
//
//        JTextArea textAreaLeft = new JTextArea("The Copier");
//        JTextArea textAreaRight = new JTextArea();
//        JButton copyButton = new JButton("Copy!");
//
//        AreaCopier copier = new AreaCopier(textAreaLeft, textAreaRight);
//        copyButton.addActionListener(copier);
//
//        container.add(textAreaLeft);
//        container.add(copyButton);
//        container.add(textAreaRight);

        GridLayout layout = new GridLayout(6, 2);
        container.setLayout(layout);

        JLabel nameText = new JLabel("Name: ");
        JTextField nameField = new JTextField();
        JLabel idText = new JLabel("ID: ");
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