package ObjectOrientedProgram;

public class TestCircle
{
    public static void main(String[] args)
    {
        StdDraw.setCanvasSize(400, 400);

        Circle c = new Circle(0.2, 0.2, 0.2, StdDraw.BLUE);
        Circle r = new Circle(0.8, 0.8, 0.2, StdDraw.GREEN);

        c.setRadius (-1);
        c.setRadius (0.5);

        c.draw();
        r.draw();
    }


}
