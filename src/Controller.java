import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    MenuPanel menuPanel;
    MazePanel mazePanel;
    Maze maze;
    int width;
    int height;

    Controller(MenuPanel menuPanel, MazePanel mazePanel) {
        this.menuPanel = menuPanel;
        this.mazePanel = mazePanel;

        this.width = 201;
        this.height = 201;
        this.maze = new Maze(width, height);

        this.maze.drawRect(0, 0, width, height, 1);
        mazePanel.paintImage(maze.getAllData());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.maze.fillRect(1, 1, this.width - 2, this.width - 2, 0);
        this.maze.generate(1, 1, this.width - 2, this.height - 2, 1);
        this.maze.setColRow(this.width - 1, 1, 3);
        this.maze.findExit(1, 1, 100);
        this.mazePanel.paintImage(this.maze.getAllData());
        this.mazePanel.repaint();
    }
}
