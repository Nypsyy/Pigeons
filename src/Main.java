import Window.Window;
import Window.Drawing;
import Window.Game;
import Window.Configuration;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Drawing drawing = new Drawing(game);
        new Window(Configuration.WindowName, Configuration.WindowWidth, Configuration.WindowHeight, drawing);
    }
}
