import java.util.Scanner;

public class Main03
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一个整数：");
        int num = sc.nextInt();
        boolean sigh = true;
        int sum = 0;

        for (; 2 <= num; num--)
        {
            int divider = num - 1;

            while (divider > 1)
            {
                if (num % divider == 0)
                {
                    sigh = false;
                    break;
                }
                divider--;
            } ;

            if (sigh)
            {
                sum += num;
            }
            sigh = true;
        }

        System.out.print("他的兰花数是："+sum);
    }
}