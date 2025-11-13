package homework02;
import java.util.Scanner;
public class Convolution
{
    public static double[][] convolution (double[][] A, double[][] K)
    {
        double[][] C = new double[A.length - K.length + 1][A[0].length - K[0].length + 1];
        for (int i = 0; i < C.length; i++)
        {
            for (int j = 0; j < C[i].length; j++)
            {
                for (int k = 0; k < K.length; k++)
                {
                    for (int l = 0; l < K[0].length; l++)
                    {
                        C[i][j] += A[i + k][j + l] * K[k][l];
                    }
                }
            }
        }

        return C;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int MA = sc.nextInt();
        int NA = sc.nextInt();
        double[][] A = new double[MA][NA];
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A[i].length; j++)
            {
                A[i][j] = sc.nextDouble();
            }
        }

        int MK = sc.nextInt();
        int NK = sc.nextInt();
        double[][] K = new double[MK][NK];
        for (int i = 0; i < K.length; i++)
        {
            for (int j = 0; j < K[i].length; j++)
            {
                K[i][j] = sc.nextDouble();
            }
        }

        double[][] C = convolution(A, K);
        for (int i = 0; i < C.length; i++)
        {
            for (int j = 0; j < C[i].length; j++)
            {
                System.out.printf("%.2f ",C[i][j]);
            }
            System.out.println();
        }
    }
}