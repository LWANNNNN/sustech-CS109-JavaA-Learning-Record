package ObjectOrientedProgram;

import java.util.Scanner;
import java.awt.*;

public class Circle
{
    private double x_coordinate;
    private double y_coordinate;
    private double r_coordinate;
    public Color color;

    public Circle(double x_coordinate, double y_coordinate, double r_coordinate, Color color)
    {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
        this.r_coordinate = r_coordinate;
        this.color = color;
    }

    public void setRadius (double newradius)
    {
        System.out.println("准备将圆形半径修改为:" + newradius);

        if (newradius > 0)
        {
            r_coordinate = newradius;
            System.out.println("修改成功");
        } else
        {
            System.out.println("修改失败");
        }
    }

    public void draw()
    {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x_coordinate, y_coordinate, r_coordinate);
        StdDraw.show();
    }
}

