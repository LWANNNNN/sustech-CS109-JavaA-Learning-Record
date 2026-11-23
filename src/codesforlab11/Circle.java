package codesforlab11;
import ObjectOrientedProgram.StdDraw;

import java.awt.*;

public class Circle extends Shape implements Comparable<Circle>, ColorDraw
{
    private double radius;
    static final int DEFAULT_RADIUS = 5;

    public Circle(double radius, double x, double y) {
        super(x, y);
        this.radius = radius;
    }

    public Circle(double radius) {
        super(0, 0);
        this.radius = radius;
    }

    public Circle(double x, double y) {
        super(x, y);
        this.radius = DEFAULT_RADIUS;
    }



    public void checkColor() {
        if (isInBoundary()) {
            color = ShapeColor.GREEN;
        } else {
            color = ShapeColor.RED;
        }
    }

    public boolean isInBoundary() {
        if (-1 * Shape.screenSize > this.getX() - this.radius || Circle.screenSize < this.getX() + this.radius) {
            return false;
        }
        if (-1 * Shape.screenSize > this.getY() - this.radius || Circle.screenSize < this.getY() + this.radius) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + " x=" + getX() +
                ", y=" + getY() +
                ", color=" + color +
                "}\n";
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public void draw() {

        StdDraw.setPenColor(color.getColor());
        StdDraw.filledCircle(getX(), getY(), radius);
    }

    @Override
    public void customizedColor(ColorScheme colorScheme, int index) {
        Color[] colorList = colorScheme.getColorScheme();
        if (index < 0){
            index = 0;
        }
        if (index >= colorList.length){
            index = index % colorList.length;
        }
        StdDraw.setPenColor(colorList[index]);
        StdDraw.filledCircle(getX(), getY(), radius);
    }

    public int compareTo(Circle o)
    {
        if (this.radius < o.radius)
        {
            return 1;
        } else if (this.radius > o.radius)
        {
            return -1;
        }
        return 0;
    }
}
