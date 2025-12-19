package homework05.Sprite;

public class StrengthenSkill extends Skill
{
    public StrengthenSkill(int skillStrength)
    {
        super(skillStrength);
    }

    public String releaseSkill(Sprite sprite)
    {
        String result = sprite.getName() + " skillStrength(" + sprite.getPrimarySkill().getSkillStrength() + ") + " + this.getSkillStrength();
        int skillStrength = sprite.getPrimarySkill().getSkillStrength();
        skillStrength += this.getSkillStrength();
        sprite.getPrimarySkill().setSkillStrength(skillStrength);
        return result;
    }

    public String getSimpleName()
    {
        return "StrengthenSkill";
    }

}
