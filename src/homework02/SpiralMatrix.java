package homework02;
import java.util.Scanner;
public class SpiralMatrix
{
    public static int[][] spiralway (int M, int N, int[] input)
    {
        int[][] result = new int[M][N];
        int i = 0;
        int left = 0;
        int right = N - 1;
        int up = 0;
        int down = M - 1;
        int x = 0;
        int y = 0;
        while (i < input.length)
        {
            while (i < input.length && y >= left && y <= right)
            {
                result[x][y] = input[i];
                i++;
                y++;
            }
            up++;
            y--;
            x++;

            while (i < input.length && x >= up && x <= down)
            {
                result[x][y] = input[i];
                i++;
                x++;
            }
            right--;
            x--;
            y--;

            while (i < input.length && y >= left && y <= right)
            {
                result[x][y] = input[i];
                i++;
                y--;
            }
            y++;
            down--;
            x--;

            while (i < input.length && x >= up && x <= down)
            {
                result[x][y] = input[i];
                i++;
                x--;
            }
            x++;
            left++;
            y++;
        }

        return result;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        int[] elements = new int[M * N];
        for (int i = 0; i < elements.length; i++)
        {
            elements[i] = sc.nextInt();
        }

        int[][] matrix = new int[M][N];
        matrix = spiralway(M, N, elements);

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}