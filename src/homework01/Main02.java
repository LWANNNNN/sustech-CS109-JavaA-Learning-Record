package homework01;

import java.util.Scanner;
public class Main02
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int m1 = input.nextInt();
        int v = input.nextInt();
        int m2 = input.nextInt();

        double v1 = (double) (v * (m1 - m2)) /(m1+m2);
        double v2 = (double) (v * (2 * m1)) /(m1+m2);

        System.out.printf("%.2f %.2f",v1,v2);
    }
}
