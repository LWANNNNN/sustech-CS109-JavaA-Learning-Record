package homework05.Sprite;

public class AttackSkill extends Skill
{
    public AttackSkill(int skillStrength)
    {
        super(skillStrength);
    }

    public String releaseSkill(Sprite sprite)
    {
        String result = sprite.getName() + " hp(" + sprite.getHp() + ") - " + this.getSkillStrength();
        int hp = sprite.getHp();
        hp -= this.getSkillStrength();
        if (hp <= 0)
        {
            sprite.setHp(0);
        } else
        {
            sprite.setHp(hp);
        }
        return result;
    }
    public String getSimpleName()
    {
        return "AttackSkill";
    }

}
