package Window;

import Object.Pigeon;
import Object.Food;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Drawing extends JPanel {
	private final World world;

	public Drawing(World world) {
		this.world = world;

		initClickListener();
		initRepaintTimer();
	}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

		for (Pigeon pigeon : world.getPigeons()) {
			pigeon.getFigure().draw(g);
		}

		for (Food food : world.getFood()) {
			food.getFigure().draw(g);
		}
	}

	private void initRepaintTimer() {
		new Timer(Configuration.screenRefreshRate, e -> repaint()).start();
	}

	private void initClickListener() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				// TODO : Fix when food spawn first
				if (e.getButton() == MouseEvent.BUTTON1) {
					world.addFood(e.getX(), e.getY());
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					world.addPigeon(e.getX(), e.getY());
				} else if (e.getButton() == MouseEvent.BUTTON2) {
					// TODO : Fix
					//world.resetWorld();
				}
			}
		});
	}
}
