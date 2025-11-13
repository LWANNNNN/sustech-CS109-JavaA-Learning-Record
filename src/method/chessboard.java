package method;

import java.util.Scanner;

public class chessboard 
{
    public static boolean check(int[][] board, int row, int column)
    {
        boolean result = false;
        if (row != 0 && row != board.length - 1 &&
            column != 0 && column != board[row].length - 1)
        {
            if (board[row][column] == 0)
            {
                if (board[row - 1][column] == 1 && board[row][column-1] == 1 &&
                        board[row][column + 1] == 1 && board[row + 1][column] == 1)
                {
                    result = true;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int row = sc.nextInt();
        int column = sc.nextInt();
        int[][] chessboard = new int[row][column];

        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                chessboard[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i < chessboard.length; i++) {
            for (int j = 0; j < chessboard[i].length; j++) {
                if (check(chessboard, i, j)) {
                    cnt++;
                }
            }
        }

        System.out.printf("There are %d bingo grids.", cnt);
    }
}
