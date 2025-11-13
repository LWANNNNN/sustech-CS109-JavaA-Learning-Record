package homework02;
import java.util.Scanner;
public class RemoveDuplication
{
    public static int[] removeduplication (int[] a)
    {
        int numofminusone = 0;
        for (int i = 0; i < a.length; i++)
        {
            int test = a[i];

            for (int j = i + 1; j < a.length; j++)
            {
                if (test != -1 && a[j] == test) {
                    a[j] = -1;
                    numofminusone++;
                }
            }
        }

        int counter = a.length - numofminusone;

        int[] result = new int[counter];
        int start = 0;
        for (int i = 0; i < result.length; i++)
        {
            for (int j = start; j < a.length; j++)
            {
                if (a[j] != -1)
                {
                    result[i] = a[j];
                    start = j + 1;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] input = new int[N];
        for (int i = 0; i < input.length; i++)
        {
            input[i] = sc.nextInt();
        }

        int[] result = removeduplication (input);
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}
