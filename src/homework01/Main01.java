package homework01;

import  java.util.Scanner;
public class Main01
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int A = input.nextInt();
        int op1 = input.nextInt();
        int B = input.nextInt();
        int op2 = input.nextInt();
        int C = input.nextInt();

        System.out.print(A + op1*B + op2*C);
    }
}
