import java.util.Scanner;
public class Main01 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter price（元）:");
        double price = in.nextDouble();

        System.out.println("票价为：" + price + "元");
        System.out.print("请输入您要购买的数量（张）：");
        double n = in.nextDouble();

        double amount =n*price;
        System.out.println("您需要支付的金额为："+amount+"元");

        System.out.print("请您输入支付的金额（元）：");
        double input = in.nextDouble();

        for(;input<amount;)
        {
            System.out.print("您支付的金额不足，请您输入你要增加的金额：");
            double addition = in.nextDouble();
            input =input+addition;
        }
        System.out.println("出票成功！");

        double change = 0;
        change  =input-amount;

        if(change>0)
        {
            System.out.println("找您"+change+"元");
        }



    }

}
