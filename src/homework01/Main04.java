package homework01;

import java.util.Scanner;
public class Main04
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int T  = input.nextInt();
        String result = "";

        for (int i = 0; i < T; i++)
        {
            int lottery = input.nextInt();
            int guess = input.nextInt();

            if (lottery == guess)
            {
                result += "10000\n";
            } else if (lottery/10 == guess%10 && lottery%10 == guess/10)
            {
                result += "3000\n";
            } else if (lottery/10 == guess%10 || lottery%10 == guess/10
                    || lottery/10 == guess/10 || lottery%10 == guess%10)
            {
                result += "1000\n";
            } else
            {
                result += "0\n";
            }
        }

        System.out.print(result);

//        int T = input.nextInt();
//        int lottery[] = new int[T];
//        int guess[] = new int[T];
//
//        for (int i = 0; i < lottery.length; i++)
//        {
//            lottery[i] = input.nextInt();
//            guess[i] = input.nextInt();
//        }
//
//        for (int j = 0; j < guess.length; j++)
//        {
//            if (lottery[j] == guess[j])
//            {
//                System.out.println("10000");
//            } else if (lottery[j]/10 == guess[j]%10 && lottery[j]%10 == guess[j]/10)
//            {
//                System.out.println("3000");
//            } else if (lottery[j]/10 == guess[j]%10 || lottery[j]%10 == guess[j]/10
//                    || lottery[j]/10 == guess[j]/10 || lottery[j]%10 == guess[j]%10)
//            {
//                System.out.println("1000");
//            } else
//            {
//                System.out.println("0");
//            }
//        }
    }
}
