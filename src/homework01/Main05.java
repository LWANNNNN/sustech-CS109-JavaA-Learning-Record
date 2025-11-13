package homework01;

import java.util.Scanner;
public class Main05
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

//        int T = input.nextInt();
//        int n0 = 1;
//        int n1 = 1;
//        String result = "";
//
//        for (int i = 0; i < T; i++)
//        {
//            int n = input.nextInt();
//
//            if (n == 0 || n == 1)
//            {
//                result += "1 ";
//            } else
//            {
//                for (int j = 0; j < n-1; j++)
//                {
//                    n1 = n0 + n1;
//                }
//
//                result += n1+" ";
//            }
//        }
//        System.out.print(result);
//        运行时间过长


        int T = input.nextInt();
        int[] n = new int[T];

        for (int i = 0; i < n.length; i++)
        {
            n[i] = input.nextInt();
        }

        for (int j = 0; j < n.length; j++)
        {
            if (n[j] == 0 || n[j] == 1)
            {
                System.out.print("1");
            } else if (n[j] > 1)
            {
                int[] F = new int[n[j]+1];
                int k = 2;
                F[0] = 1;
                F[1] = 1;

                for (k = 2; k < F.length; k++)
                {
                    F[k] = F[k-1] + F[k-2];
                }
                System.out.print(F[k-1]);
            }

            if (j < n.length-1)
            {
                System.out.print(" ");
            }
        }
    }
}
