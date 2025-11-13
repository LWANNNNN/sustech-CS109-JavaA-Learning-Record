import java.util.Scanner;

public class Main1
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the number of courses: ");
        int cnum = input.nextInt();
        System.out.print("Please enter the number of students: ");
        int snum = input.nextInt();

        int[][] score = new int[cnum][snum];
        double[] cave = new double[snum];
        double[] save = new double[cnum];

        for (int i = 0; i < cnum; i++)
        {
            int csum = 0;
            for (int j = 0; j < snum; j++)
            {
                score[i][j] = input.nextInt();
                csum = csum + score[i][j];
            }
            save[i] = (double) csum/snum;
        }

        for (int i = 0; i < snum; i++)
        {
            int ssum = 0;
            for (int j = 0; j <cnum; j++)
            {
                ssum = ssum + score[j][i];
            }
            cave[i] = (double) ssum/cnum;
        }

        System.out.println();
        System.out.print("\t\t\t");
        for (int i = 0; i < cnum; i++)
        {
            System.out.print("Course" + (i + 1) +"\t");
        }
        System.out.print(" Average\n");

        for (int i = 0; i < snum; i++)
        {
            System.out.print("Student" + (i+1) + "\t");
            for (int j = 0; j < cnum; j++)
            {
                System.out.print("  "+score[j][i] + "\t");
            }
            System.out.printf("  %.2f\n", cave[i]);

        }

        System.out.print("Average\t\t");
        for (int i =0; i < cnum; i++)
        {
            System.out.printf("  %.2f\t",save[i]);
        }


     }
}
