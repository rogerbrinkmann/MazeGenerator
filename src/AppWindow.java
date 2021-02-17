import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class AppWindow extends JFrame {

    MenuPanel menuPanel;
    MazePanel mazePanel;
    Controller controller;

    AppWindow() {
        this.setTitle("Maze");
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        this.menuPanel = new MenuPanel(804, 30);
        this.mazePanel = new MazePanel(804, 804);
        this.controller = new Controller(this.menuPanel, this.mazePanel);

        this.add(this.menuPanel, BorderLayout.NORTH);
        this.add(this.mazePanel, BorderLayout.CENTER);
        this.setResizable(false);
        this.pack();
    }
}
