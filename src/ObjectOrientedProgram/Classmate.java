package ObjectOrientedProgram;

import java.util.Scanner;

public class Classmate {
    private String name;
    private String birthday;
    private String phoneNumber;
    private String address;
    private String dream;

    public String getPhoneNumber() {
        System.out.println("请输入管理员密码：");
        Scanner in = new Scanner(System.in);
        String password = in.next();
        if (password.equals("123456")) {
            return phoneNumber;
        } else {
            System.out.println("密码错误，无权查看");
            return null;
        }
    }

    public boolean setPhoneNumber(String phoneNumber) {
        if (phoneNumber.charAt(0) != '1' || phoneNumber.length() != 11)
            return false;
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (!Character.isDigit(phoneNumber.charAt(i)))
                return false;

        }
        this.phoneNumber = phoneNumber;
        return true;
    }

    public Classmate(String name, String birthday, String phoneNumber, String address, String dream) {
        this.name = name;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.dream = dream;
        this.address = address;

    }

    public void introduce() {
        System.out.printf("My name is %s, my birthday is %s, " +
                        "my phone is %s, I live in %s, my dream is %s\n",
                name, birthday, phoneNumber, address, dream);
    }
}


