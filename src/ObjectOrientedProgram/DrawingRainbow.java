package ObjectOrientedProgram;

import java.awt.*;

public class DrawingRainbow
{
    public static void main(String[] args)
    {
        StdDraw.setCanvasSize(400, 400);
        StdDraw.clear(StdDraw.WHITE);

        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.filledCircle(0.5, 0, 0.5);

        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledCircle(0.5, 0, 0.45);

        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(0.5, 0, 0.40);

        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledCircle(0.5, 0, 0.35);

        StdDraw.setPenColor(StdDraw.CYAN);
        StdDraw.filledCircle(0.5, 0, 0.3);

        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.filledCircle(0.5, 0, 0.25);

        StdDraw.setPenColor(new Color(100, 40, 250));
        StdDraw.filledCircle(0.5, 0, 0.2);

        StdDraw.setPenColor(StdDraw.WHITE);
        StdDraw.filledCircle(0.5, 0, 0.15);

        StdDraw.show();
    }
}
