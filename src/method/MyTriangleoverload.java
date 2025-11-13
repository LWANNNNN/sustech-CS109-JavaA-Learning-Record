package method;
import java.util.Scanner;

import static java.lang.Math.sin;

public class MyTriangleoverload {

    public static double area (double bottom, double height)
    {
        double area = 0.5 * bottom * height;
        return area;
    }

    public static double area (double a, double b, int angleOfAandB)
    {
        double angle = angleOfAandB * Math.PI/180;
        double area = 0.5 * a * b * sin(angle);
        return area;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Please input two numbers for bottom and height:");

        double a = in.nextDouble();
        double b = in.nextDouble();
        System.out.printf("The area is %.3f\n", area(a, b));

        System.out.println("Please input two numbers for a and b:");
        a = in.nextDouble();
        b = in.nextDouble();
        System.out.println("Please input a number in (0,180) for angle (angle is int):");
        int c = in.nextInt();
        System.out.printf("The area is %.3f\n", area(a, b, c));
    }


}
