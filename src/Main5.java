import java.util.Scanner;

public class Main5 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of myLists:");
        int T = sc.nextInt();
        double[] myList1 = new double[T];
        double[] myList2 = new double[T];
        double[] myList3 = new double[T];

        System.out.print("Enter " + T + " values:");

        for(int i=0;i<T;i++)
        {
            myList1[i] = sc.nextDouble();
            myList2[i] = myList1[i];
        }
        for(int i = 0;i < T; i++)
        {
            myList1[i] = myList2[T-1-i];
            myList3[i] = myList1[i] + myList2[i];
        }

        System.out.print("myList1:");
        for(int i=0;i<T;i++)
        {
            System.out.print(myList1[i] + " ");
        }
        System.out.println();
        System.out.print("myList2:");
        for(int i=0;i<T;i++)
        {
            System.out.print(myList2[i] + " ");
        }
        System.out.println();
        System.out.print("myList3:");
        for(int i=0;i<T;i++)
        {
            System.out.print(myList3[i] + " ");
        }
    }
}
