package homework01;

import java.util.Scanner;
public class Main03
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int x = input.nextInt();
        int y = input.nextInt();
        int z = input.nextInt();
        int a = input.nextInt();

        if (x < 5 || y < 9)
        {
            System.out.print("Yes");
        } else if (a == 0)
        {
            System.out.print("Yes");
        } else if (y >= 10)
        {
            System.out.print("No");
        } else if (z <= 45)
        {
            System.out.print("Yes");
        } else
        {
            System.out.print("No");
        }
    }
}
