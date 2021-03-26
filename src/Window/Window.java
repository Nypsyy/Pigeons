package Window;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    private final int width;
    private final int height;

    public Window(String name, int width, int height, Drawing drawing) {
        super(name);

        this.width = Math.abs(width);
        this.height = Math.abs(height);

        configureContainer(drawing);
        configureWindow();
    }

    private void configureWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setResizable(false);
        setVisible(true);
    }

    private void configureContainer(Drawing drawing) {
        Container container = getContentPane();
        container.add(drawing, BorderLayout.CENTER);
    }
}
