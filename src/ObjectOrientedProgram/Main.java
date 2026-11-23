package ObjectOrientedProgram;

public class Main
{
    public static void main(String[] args)
    {
        Classmate zhangsan = new Classmate("张三", "20100920", "13933339999", "学苑大道1088号", "考试100分！");
        zhangsan.setPhoneNumber("hahahah");
        zhangsan.introduce();
        //zhangsan.phoneNumber="heiheihei";
        zhangsan.introduce();
    }
}


