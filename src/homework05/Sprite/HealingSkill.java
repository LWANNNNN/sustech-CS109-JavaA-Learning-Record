package homework05.Sprite;

public class HealingSkill extends Skill
{
    public HealingSkill(int skillStrength)
    {
        super(skillStrength);
    }

    public String releaseSkill(Sprite sprite)
    {
        String result = sprite.getName() + " hp(" + sprite.getHp() + ") + " + this.getSkillStrength();
        int hp = sprite.getHp();
        hp += this.getSkillStrength();
        sprite.setHp(hp);
        return result;
    }
    public String getSimpleName()
    {
        return "HealingSkill";
    }

}
