import Window.Window;
import Window.Drawing;
import Window.World;

public class Main {
    public static void main(String[] args) {
        World world = new World();
        Drawing drawing = new Drawing(world);
        new Window("Pigeons Simulator", 960, 720, drawing);
    }
}
