import java.util.Scanner;
public class Main02

{


    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        System.out.print("请输入两个整数（以空格隔开）:");
        int num1 = in.nextInt();
        int num2 = in.nextInt();
        int factor = Math.min(num1,num2);
        boolean sigh = false;

        for(;factor>1;factor--)
        {
            if(num1%factor==0 && num2%factor==0)
            {
                System.out.println("他们的最大公约数是:"+factor);
                sigh = true;
                break;
            }
        }

        if(!sigh)
        {
            System.out.println("无最大公约数");
        }

    }


}