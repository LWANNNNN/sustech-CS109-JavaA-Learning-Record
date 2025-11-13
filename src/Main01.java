import java.util.Arrays;
public class Main01
{
    public static void printArray(int[] array , String description)
    {
        System.out.printf("%s:", description);
        for (int value : array)
        {
            System.out.printf("%d", value);
        }
    }

    public static void main(String[] args)
    {
        int[] array1 = new int[10];
        for (int i = 0; i < array1.length; i++)
        {
            array1[i] = i;
        }

        printArray(array1, "hahaha");
    }
}
