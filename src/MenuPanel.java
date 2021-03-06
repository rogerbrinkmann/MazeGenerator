import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class MenuPanel extends JPanel {

    private final int width;
    private final int height;

    Button generateButton;

    MenuPanel(int width, int height) {
        this.width = width;
        this.height = height;
        this.setPreferredSize(new Dimension(this.width, this.height));

        this.generateButton = new Button("Generate");
        this.add(generateButton);

    }
}
