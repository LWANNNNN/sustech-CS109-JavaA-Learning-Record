package homework05.Sprite;

public abstract class Skill
{
    private int skillStrength;

    public abstract String releaseSkill(Sprite sprite);
    public abstract String getSimpleName();

    public Skill(int skillStrength)
    {
        this.skillStrength = skillStrength;
    }

    public int getSkillStrength()
    {
        if (this.skillStrength <= 0)
        {
            return 0;
        }
        else
        {
            return this.skillStrength;
        }
    }
    public void setSkillStrength(int skillStrength)
    {
        if (skillStrength <= 0)
        {
            this.skillStrength = 0;
        } else
        {
            this.skillStrength = skillStrength;
        }
    }
}
