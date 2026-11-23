package method;

import java.util.Scanner;

public class MyTriangle1 {

    public static boolean isVaild(double a, double b, double c)
    {
        boolean isVaid = true;
        if (a + b <= c || b + c <= a || a + c <= b)
        {
            isVaid = false;
        }
        return isVaid;
    }

    public static double perimeter (double a, double b, double c)
    {
        double perimeter = a + b + c;
        return perimeter;
    }

    public static double area(double a, double b, double c)
    {
        double p = perimeter(a, b, c)/2;
        return Math.sqrt(p * (p - a)*(p - b)*(p - c));
    }

    public static void main(String[] args)
    {
        System.out.println("please input three numbers for a, b, c:");
        Scanner in = new Scanner(System.in);
        double a, b, c;
        a = in.nextDouble();

        while (a != -1)
        {
            b = in.nextDouble();
            c = in.nextDouble();

            if (isVaild(a, b, c))
            {
                System.out.printf("The area is %.3f.\n", area(a, b, c));
                System.out.printf("The perimeter is %.3f.\n", perimeter(a, b, c));
            } else
            {
                System.out.println("The input is invaild.");
            }

            System.out.println("Please input three numbers for a, b, c:");
            a = in.nextDouble();
        }

        System.out.println("Bye~");

    }
}
