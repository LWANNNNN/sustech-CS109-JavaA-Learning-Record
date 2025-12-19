package homework05.Student;

public class Student implements Comparable<Student>
{
    private String name;
    private String id;
    private int score;

    public Student(String id, String name, int score)
    {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String toString()
    {
        return name + " - id: " + id + ", score: " + score;
    }

    public int compareTo(Student otherStudent)
    {
        if (this.score < otherStudent.score)
        {
            return 1;
        } else if (this.score > otherStudent.score)
        {
            return -1;
        } else
        {
            if (this.id.compareTo(otherStudent.id) > 0)
            {
                return 1;
            } else if (this.id.compareTo(otherStudent.id) < 0)
            {
                return -1;
            } else
            {
                return 0;
            }
        }
    }

    public String getName()
    {
        return this.name;
    }
    public String getId()
    {
        return this.id;
    }
    public int getScore()
    {
        return this.score;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public void setScore(int score)
    {
        this.score = score;
    }
}