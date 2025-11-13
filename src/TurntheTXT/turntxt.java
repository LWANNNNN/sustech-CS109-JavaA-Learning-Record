package TurntheTXT;

import java.io.*;
import java.util.Scanner;

public class turntxt
{
    public static void main(String[] args) throws IOException
    {
        File TestIn = new File(".\\src\\TurntheTXT\\TestIn.txt");
        Scanner sc;
        try
        {
            sc = new Scanner (TestIn);
            String input  = sc.nextLine();
            BufferedWriter writer = new BufferedWriter( new FileWriter(".\\src\\TurntheTXT\\TestOut.txt"));
            writer.write (new StringBuilder (input).reverse().toString());
            writer.close();
        } catch(Exception e)
        {
            System.out.println("File not found!");
        }
    }
}
