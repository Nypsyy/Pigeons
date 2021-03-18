import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SwingWindow extends JFrame {
    public SwingWindow() {
        super("Exemple");

        WindowListener wl = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        };

        addWindowListener(wl);
        setSize(854, 480);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new SwingWindow();
    }
}
