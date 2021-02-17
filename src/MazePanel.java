import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class MazePanel extends JPanel {

    private final int width;
    private final int height;
    private final BufferedImage img;

    MazePanel(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(this.width, this.height));
        this.img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
    }

    public void paintImage(int[][] data) {
        double rows = data.length;
        double cols = data[0].length;
        double rectWidth = this.width / cols;
        double rectHeight = this.height / rows;
        Graphics g = img.getGraphics();

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                if (data[y][x] == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(new Color(data[y][x], data[y][x], data[y][x]));
                }
                g.fillRect((int) (x * rectWidth), (int) (y * rectHeight), (int) rectWidth + 1, (int) rectHeight + 1);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);
    }
}
