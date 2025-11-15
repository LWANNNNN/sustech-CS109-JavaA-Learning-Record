import java.util.*;

import static com.sun.tools.javac.main.Option.X;
import static java.util.Objects.hash;

public class Main04
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
//        final int size = 3;
//        int numofX = 0;
//        int numofO = 0;
//        int [][] board =  new int[size][size];
//
//        for (int i = 0; i<board.length; i++)
//        {
//            for (int j = 0; j<board[i].length; j++)
//            {
//                board[i][j] = sc.nextInt();
//            }
//        }
//
//        for (int x = 0; x<board.length; x++)
//        {
//            for (int y = 0; y<board[x].length; y++)
//            {
//                if (board[x][y] == 1)
//                {
//                    numofX++;
//                } else
//                {
//                    numofO++;
//                }
//            }
//            if (numofX==3 || numofO==3)
//            {
//                System.out.println("Bingo!");
//            }
//            numofX = 0;
//            numofO = 0;
//        }
//
//        for (int y = 0; y<board.length; y++)
//        {
//            for (int x = 0; x < board[y].length; x++)
//            {
//                if (board[x][y] == 1)
//                {
//                    numofX++;
//                } else
//                {
//                    numofO++;
//                }
//            }
//            if (numofX == 3 || numofO == 3)
//            {
//                System.out.println("Bingo!");
//            }
//            numofX = 0;
//            numofO = 0;
//        }
//
//        for (int x = 0, y = 0; x<size && y<size; x++, y++)
//        {
//            if (board[x][y] == 1)
//            {
//                numofX++;
//            } else
//            {
//                numofO++;
//            }
//            if (numofX == 3 || numofO ==3)
//            {
//                System.out.println("Bingo!");
//                numofX = 0;
//                numofO = 0;
//            }
//        }
//
//        for (int x = 0, y = size-1; x<size && y>=0; x++, y--)
//        {
//            if (board[x][y] == 1)
//            {
//                numofX++;
//            } else
//            {
//                numofO++;
//            }
//            if (numofX == 3 || numofO ==3)
//            {
//                System.out.println("Bingo!");
//                numofX = 0;
//                numofO = 0;
//            }
//        }


        String a = "cola";
        String b ="d";


        if(a == b){
            System.out.println(1);
        }


        if(a.equals(b)){
            System.out.println(2);
        }

        if(b.equals(a)){
            System.out.println(3);
        }


        //if(a.hash(a))

    }

}
