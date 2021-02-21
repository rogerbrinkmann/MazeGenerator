import java.awt.event.*;

public class Controller implements ActionListener{

    MenuPanel menuPanel;
    MazePanel mazePanel;

    Controller(MenuPanel menuPanel, MazePanel mazePanel) {
        this.menuPanel = menuPanel;
        this.menuPanel.generateButton.addActionListener(this);
        this.mazePanel = mazePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.menuPanel.generateButton) {
            this.mazePanel.maze.fillRect(1, 1, mazePanel.maze.cols - 2, mazePanel.maze.rows - 2, 0);
            this.mazePanel.maze.generate(1, 1, mazePanel.maze.cols - 2, mazePanel.maze.rows - 2, 1);

            // exit: value = 3
            this.mazePanel.maze.setColRow(mazePanel.maze.cols - 1, mazePanel.maze.rows - 2, 3);
            this.mazePanel.maze.findExit(1, 1, 5);

            // start: value = 2
            this.mazePanel.maze.setColRow(1, 1, 2);
            //this.mazePanel.maze.findPath(mazePanel.maze.cols - 2, mazePanel.maze.rows - 2, 100000, 4);
            this.mazePanel.repaint();
        }
    }
}
