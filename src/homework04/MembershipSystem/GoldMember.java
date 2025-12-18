package homework04.MembershipSystem;

public class GoldMember extends Member
{
    public GoldMember(String name)
    {
        super(name);
    }

    public int usePoints(int totalAmount)
    {
        int numOfNeededBlocks = totalAmount/100;
        int maxPointsUsage = numOfNeededBlocks *20;
        int numOfcurrentBlocks = this.getPoints()/20;
        if (numOfcurrentBlocks == 0)
        {
            return 0;
        } else if (numOfcurrentBlocks <= numOfNeededBlocks)
        {
            this.reducePoints(numOfcurrentBlocks*20);
            return numOfcurrentBlocks*20;
        } else
        {
            this.reducePoints(numOfNeededBlocks*10);
            return numOfNeededBlocks*10;
        }
    }
}
