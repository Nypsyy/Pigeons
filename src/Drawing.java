import Shape.Circle;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JPanel {
	private final Pigeon pigeon;
	// TODO : Food

	public Drawing() {
		pigeon = new Pigeon(1);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		for (Circle circle : pigeon.getPigeons()) {
			circle.draw(g);
		}
	}
}
