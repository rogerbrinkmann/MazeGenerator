public class Controller {

    MenuPanel menuPanel;
    MazePanel mazePanel;
    Maze maze;

    Controller(MenuPanel menuPanel, MazePanel mazePanel){
        this.menuPanel = menuPanel;
        this.mazePanel = mazePanel;
        int width = 201;
        int height = 201;
        this.maze = new Maze(width, height);

        this.maze.drawRect(0,0,width,height,1);

        this.maze.generate(1,1,width-2,height-2, 1);
        mazePanel.paintImage(maze.getAllData());
    }
}
