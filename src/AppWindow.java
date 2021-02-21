import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class AppWindow extends JFrame {

    MenuPanel menuPanel;
    MazePanel mazePanel;
    Controller controller;

    AppWindow() {
        this.setTitle("Maze");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        this.menuPanel = new MenuPanel((int) (screenSize.getWidth() * 0.8), 30);
        this.mazePanel = new MazePanel(screenSize);
        this.controller = new Controller(this.menuPanel, this.mazePanel);
        
        this.add(this.menuPanel, BorderLayout.NORTH);
        this.add(this.mazePanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
