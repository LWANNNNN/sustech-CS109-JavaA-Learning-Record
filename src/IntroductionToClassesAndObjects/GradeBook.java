package IntroductionToClassesAndObjects;

public class GradeBook
{
    private String courseName;

    public void setCourseName (String name)
    {
        courseName = name;
    }

    public String getCourseName ()
    {
        return courseName;
    }

    public void displaceMessage()
    {
        System.out.printf("Welcome to the grade book for %s!\n", getCourseName());
    }

    public static void main(String[] args)
    {
        GradeBook myGradeBook  = new GradeBook();
        myGradeBook.displaceMessage();
    }
}
