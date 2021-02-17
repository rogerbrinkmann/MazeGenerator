import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    private final int width;
    private final int height;

    MenuPanel(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(this.width, this.height));
    }
}
