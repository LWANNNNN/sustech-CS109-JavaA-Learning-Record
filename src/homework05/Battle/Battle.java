package homework05.Battle;

import homework05.Sprite.EffectIntensity;
import homework05.Sprite.Sprite;

import javax.swing.*;

public class Battle
{
    Sprite homeSprite;
    Sprite awaySprite;

    public Battle(Sprite homeSprite, Sprite awaySprite)
    {
        this.homeSprite = homeSprite;
        this.awaySprite = awaySprite;
    }

    public Sprite getHomeSprite()
    {
        return this.homeSprite;
    }
    public Sprite getAwaySprite()
    {
        return this.awaySprite;
    }
    public void setHomeSprite(Sprite homeSprite)
    {
        this.homeSprite = homeSprite;
    }
    public void setAwaySprite(Sprite awaySprite)
    {
        this.awaySprite = awaySprite;
    }

    public void skillAction(Sprite currentSprite, Sprite oppositeSprite, int skillOrder)
    {
        if (skillOrder == 1)
        {
            switch (currentSprite.getPrimarySkill().getSimpleName())
            {
                case "AttackSkill":
                {
                    System.out.println(currentSprite.getPrimarySkill().releaseSkill(oppositeSprite));
                    break;
                }
                case "HealingSkill":
                {
                    System.out.println(currentSprite.getPrimarySkill().releaseSkill(currentSprite));
                    break;
                }
            }
        } else if (skillOrder == 2)
        {
            switch (currentSprite.getSecondarySkill().getSimpleName())
            {
                case "AttackSkill":
                {
                    System.out.println(currentSprite.getSecondarySkill().releaseSkill(oppositeSprite));
                    break;
                }
                case "HealingSkill":
                {
                    System.out.println(currentSprite.getSecondarySkill().releaseSkill(currentSprite));
                    break;
                }
                case "StrengthenSkill":
                {
                    System.out.println(currentSprite.getSecondarySkill().releaseSkill(currentSprite));
                    break;
                }
            }
        }

    }
    public BattleOutcome begin1v1Battle()
    {
        int hsOriginalHp = homeSprite.getHp();
        int asOriginalHp = awaySprite.getHp();
        int hspsOriginalSkillStrength = homeSprite.getPrimarySkill().getSkillStrength();
        int hsssOriginalSkillStrength = homeSprite.getSecondarySkill().getSkillStrength();
        int aspsOriginalSkillStrength = awaySprite.getPrimarySkill().getSkillStrength();
        int asssOriginalSkillStrength = awaySprite.getSecondarySkill().getSkillStrength();

        int hspsSkillStrength = hspsOriginalSkillStrength;
        int hsssSkillStrength = hsssOriginalSkillStrength;
        int aspsSkillStrength = aspsOriginalSkillStrength;
        int asssSkillStrength = asssOriginalSkillStrength;

        BattleOutcome result = BattleOutcome.DRAW;

        EffectIntensity hsEffectIntensity = homeSprite.compareType(awaySprite);
        hspsSkillStrength += hsEffectIntensity.getValue();
        hsssSkillStrength += hsEffectIntensity.getValue();
        homeSprite.getPrimarySkill().setSkillStrength(hspsSkillStrength);
        homeSprite.getSecondarySkill().setSkillStrength(hsssSkillStrength);
        EffectIntensity asEffectIntensity = awaySprite.compareType(homeSprite);
        aspsSkillStrength += asEffectIntensity.getValue();
        asssSkillStrength += asEffectIntensity.getValue();
        awaySprite.getPrimarySkill().setSkillStrength(aspsSkillStrength);
        awaySprite.getSecondarySkill().setSkillStrength(asssSkillStrength);


        for (int i = 0; i < 10; i++)
        {
            skillAction(homeSprite, awaySprite, 1);
            if (awaySprite.getHp() == 0)
            {
                result = BattleOutcome.VICTORY;
                break;
            }
            skillAction(awaySprite, homeSprite, 1);
            if (homeSprite.getHp() == 0)
            {
                result = BattleOutcome.DEFEAT;
                break;
            }
            skillAction(homeSprite, awaySprite, 2);
            if (awaySprite.getHp() == 0)
            {
                result = BattleOutcome.VICTORY;
                break;
            }
            skillAction(awaySprite, homeSprite, 2);
            if (homeSprite.getHp() == 0)
            {
                result = BattleOutcome.DEFEAT;
                break;
            }
        }

        homeSprite.setHp(hsOriginalHp);
        awaySprite.setHp(asOriginalHp);
        homeSprite.getPrimarySkill().setSkillStrength(hspsOriginalSkillStrength);
        homeSprite.getSecondarySkill().setSkillStrength(hsssOriginalSkillStrength);
        awaySprite.getPrimarySkill().setSkillStrength(aspsOriginalSkillStrength);
        awaySprite.getSecondarySkill().setSkillStrength(asssOriginalSkillStrength);

        return result;
    }
}
