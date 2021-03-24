import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final Drawing drawing;
    private final int width;
    private final int height;

    public Window(String name, int width, int height) {
        super(name);

        this.drawing = new Drawing();
        this.width = Math.abs(width);
        this.height = Math.abs(height);

        configureContainer();
        configureWindow();
    }

    private void configureWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(this.width, this.height);
        setVisible(true);
    }

    private void configureContainer() {
        Container container = getContentPane();
        container.add(drawing, BorderLayout.CENTER);
    }
}
