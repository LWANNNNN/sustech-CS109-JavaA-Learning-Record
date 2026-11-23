import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num = new int[100];
        for (int i = 0; i < num.length; i++) {
            num[i] = 0;
        }

        System.out.print("Enter the integers between 1 and 100: ");


        int input = 1;
        while(input != 0)
        {
            input = sc.nextInt();
            if (input != 0)
            {
                num[input - 1]++;
            }
        }

        for (int i = 0; i < num.length; i++) {
            if (num[i] == 1) {
                System.out.println((i + 1) + " occurs " + 1 + " time");
            } else if (num[i] > 1) {
                System.out.println((i + 1) + " occurs " + num[i] + " times");
            }
        }
    }
}

