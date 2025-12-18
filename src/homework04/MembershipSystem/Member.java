package homework04.MembershipSystem;

public class Member
{
    private static int nextId = 1001;
    private String memberId;
    private String name;
    private int points;

    public String getMemberId()
    {
        return this.memberId;
    }
    public String getName()
    {
        return this.name;
    }
    public int getPoints()
    {
        return this.points;
    }

    public Member(String name)
    {
        this.memberId = "M" + nextId;
        nextId++;
        this.name = name;
        this.points = 0;
    }

    public void addPoints(int amount)
    {
        points += amount;
    }
    public void reducePoints(int amount)
    {
        if (amount >= points)
        {
            points = 0;
        } else
        {
            points -= amount;
        }
    }

    public int usePoints(int totalAmount)
    {
        int numOfNeededBlocks = totalAmount/100;
        int maxPointsUsage = numOfNeededBlocks *10;
        int numOfcurrentBlocks = this.points/10;
        if (numOfcurrentBlocks == 0)
        {
            return 0;
        } else if (numOfcurrentBlocks <= numOfNeededBlocks)
        {
            this.points -= numOfcurrentBlocks*10;
            return numOfcurrentBlocks*10;
        } else
        {
            this.points -= numOfNeededBlocks*10;
            return numOfNeededBlocks*10;
        }
    }

    public String toString()
    {
        return "Member " + memberId + " (" + name + "): " + points + " points";
    }
}
