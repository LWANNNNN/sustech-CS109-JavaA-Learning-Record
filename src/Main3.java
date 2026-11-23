import java.util.Scanner;

public class Main3 {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        int[] block = new int[T];
        int max = 0;
        for (int i = 0; i < block.length; i++)
        {
            block[i] = input.nextInt();

            if (block[i] > max)
            {
                max = block[i];
            }
        }

        int sum = 0;
        int left = 0;
        int right = block.length - 1;

        for (int i = max; i > 0; i--)
        {
            for (int j = 0; j < block.length; j++)
            {
                if (block[j] > 0)
                {
                    left = j;
                    for (int k = j + 1; k <= right; k++)
                    {
                        if (block[k] > 0)
                        {
                            right = k;
                            sum = sum + (right - left - 1);
                        }
                        j = right - 1;
                    }
                }
                right = block.length - 1;
            }

            for (int j = 0; j < block.length; j++)
            {
                block[j]--;
            }
        }

        System.out.print(sum);
    }
}
