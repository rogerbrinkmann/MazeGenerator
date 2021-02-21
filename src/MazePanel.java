import javax.swing.*;

import java.awt.*;
import java.awt.image.*;

@SuppressWarnings("serial")
public class MazePanel extends JPanel {

    private final BufferedImage img;
    Maze maze;
    int scale;

    MazePanel(Dimension screenSize) {

        this.scale = 20;
        Dimension panelDimension = new Dimension((int) (screenSize.width * 0.8), (int) (screenSize.height * 0.8));
        this.setPreferredSize(panelDimension);

        int mazeWidth = panelDimension.width / this.scale;
        mazeWidth += mazeWidth % 2 - 1;
        int mazeHeight = panelDimension.height / this.scale;
        mazeHeight += mazeHeight % 2 - 1;

        this.img = new BufferedImage(mazeWidth, mazeHeight, BufferedImage.TYPE_INT_RGB);
        this.maze = new Maze(mazeWidth, mazeHeight);
        this.maze.drawRect(0, 0, mazeWidth, mazeHeight, 1);

    }

    public void paintImage() {
        for (int row = 0; row < this.maze.data.length; row++) {
            for (int col = 0; col < this.maze.data[0].length; col++) {
                switch (this.maze.data[row][col]) {
                    case 0:
                        this.img.setRGB(col, row, Color.WHITE.getRGB());
                        break;
                    case 1:
                        this.img.setRGB(col, row, Color.BLACK.getRGB());
                        break;
                    case 2:
                        this.img.setRGB(col, row, Color.GREEN.getRGB());
                        break;
                    case 3:
                        this.img.setRGB(col, row, Color.RED.getRGB());
                        break;
                    case 4:
                        this.img.setRGB(col, row, Color.YELLOW.getRGB());
                        break;
                    default:
                        this.img.setRGB(col, row, Color.BLUE.getRGB());
                }
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintImage();
        g.drawImage(this.img.getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_DEFAULT), 0, 0, null);
        g.dispose();
    }
}
