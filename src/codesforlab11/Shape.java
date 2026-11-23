package codesforlab11;

public abstract class Shape {

    private double x;
    private double y;

    protected static int screenSize = 10;
    protected ShapeColor color = ShapeColor.GRAY;

    public Shape(double x,double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public static int getScreenSize() {
        return screenSize;
    }

    public static void setScreenSize(int screenSize) {
        Shape.screenSize = screenSize;
    }

    public void draw()
    {

    }
    public void checkColor()
    {

    }

    public void setColor(ShapeColor color)
    {
        this.color = color;
    }
}
