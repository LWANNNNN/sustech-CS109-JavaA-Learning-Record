package homework02;
import java.util.Scanner;
public class SumTo24
{
    public static int numofways (int[] a) {
        int cnt = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                for (int k = j + 1; k < a.length; k++) {
                    for (int l = k + 1; l < a.length; l++) {
                        if (a[i] + a[j] + a[k] + a[l] == 24) {
                            cnt++;
                        }
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [] input = new int[N];
        for (int i = 0; i < input.length; i++)
        {
            input[i] = sc.nextInt();
        }

        System.out.print(numofways(input));
    }
}