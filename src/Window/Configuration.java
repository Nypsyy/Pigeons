package Window;

import java.awt.*;

public class Configuration {
    public static final String WindowName = "Pigeons Simulator";
    public static final int WindowWidth = 960;
    public static final int WindowHeight = 720;

    public static final Color foodDefaultColor = Color.GREEN;
    public static final Color foodEventColor = Color.RED;
    public static final int foodSize = 10;
    public static final int foodThickness = 1;
    public static final int freshTimer = 5;

    public static final Color pigeonDefaultColor = Color.BLACK;
    public static final Color pigeonEventColor = Color.CYAN;
    public static final Color pigeonThreatenedColor = Color.MAGENTA;
    public static final int pigeonSize = 25;
    public static final int pigeonThickness = 1;
    public static final int pigeonMaxSpeed = 5;
    public static final int pigeonMaxThreatenedTimer = 60;

    public static final int screenRefreshRate = 50;
}
