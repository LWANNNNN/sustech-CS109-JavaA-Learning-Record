package EnumPractice;

import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Your budget: ");
        int budget = sc.nextInt();

        if (budget < 5588)
        {
            System.out.println("You do not have sufficient money");
        } else
        {
            PhoneModel[] models = PhoneModel.values();
            for (PhoneModel model : models)
            {
                if (budget >= model.getPrice())
                {
                    if (model == PhoneModel.LG)
                    {
                        System.out.println(model +"\t\t" + "price: " + model.getPrice());
                    } else
                    {
                        System.out.println(model + "\t" + "price: " + model.getPrice());
                    }
                }
            }
        }

    }
}
