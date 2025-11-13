package homework02;
import java.util.Scanner;
public class Combine2Arrays
{
    public static int[] combine (int[] a, int[] b)
    {
        int[] combination = new int[a.length + b.length];

        for (int i = 0; i < a.length; i++)
        {
            combination[i] = a[i];
        }
        for (int i = a.length; i < a.length + b.length; i++)
        {
            combination[i] = b[i - a.length];
        }

        return combination;
    }

    public static int[] sort (int[] a)
    {
        int[] result = new int[a.length];

        for (int i = 0; i < result.length; i++)
        {
            result[i] = 1000;

            for(int j = 0; j < a.length; j++)
            {
                if (result[i] > a[j])
                {
                    result[i] = a[j];
                }
            }

            for (int j = 0; j < a.length; j++)
            {
                if (a[j] == result[i])
                {
                    a[j] = 1000;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N1 = sc.nextInt();
        int[] Array1 = new int[N1];
        for (int i = 0; i < Array1.length; i++)
        {
            Array1[i] = sc.nextInt();
        }

        int N2 = sc.nextInt();
        int[] Array2 = new int[N2];
        for (int i = 0; i < Array2.length; i++)
        {
            Array2[i] = sc.nextInt();
        }

        int[] combination = combine (Array1, Array2);
        int[] result = sort (combination);

        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i] + " ");
        }
    }
}
