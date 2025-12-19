package homework05.Sprite;

import javax.swing.*;

public class Sprite implements Comparable<Sprite>
{
    private String name;
    private String id;
    ElementType elementType;
    private int hp;
    private Skill primarySkill;
    private Skill secondarySkill;
    public int points;
    public int participationCount;

    public Sprite(String name, String id, ElementType elementType, int hp, Skill primarySkill, Skill secondarySkill)
    {
        this.name = name;
        this.id = id;
        this.elementType = elementType;
        this.hp = hp;
        this.primarySkill = primarySkill;
        this.secondarySkill = secondarySkill;
        this.points = 0;
        this.participationCount = 0;
    }

    public EffectIntensity compareType(Sprite other)
    {
        switch (this.elementType)
        {
            case METAL:
            {
                if (other.elementType == ElementType.WOOD)
                {
                    return EffectIntensity.STRENGTHENED;
                } else if (other.elementType == ElementType.FIRE)
                {
                    return EffectIntensity.WEAKENED;
                } else
                {
                    return EffectIntensity.UNCHANGED;
                }
            }
            case WOOD:
            {
                if (other.elementType == ElementType.EARTH)
                {
                    return EffectIntensity.STRENGTHENED;
                } else if (other.elementType == ElementType.METAL)
                {
                    return EffectIntensity.WEAKENED;
                } else
                {
                    return EffectIntensity.UNCHANGED;
                }
            }
            case EARTH:
            {
                if (other.elementType == ElementType.WATER)
                {
                    return EffectIntensity.STRENGTHENED;
                } else if (other.elementType == ElementType.WOOD)
                {
                    return EffectIntensity.WEAKENED;
                } else
                {
                    return EffectIntensity.UNCHANGED;
                }
            }
            case WATER:
            {
                if (other.elementType == ElementType.FIRE)
                {
                    return EffectIntensity.STRENGTHENED;
                } else if (other.elementType == ElementType.EARTH)
                {
                    return EffectIntensity.WEAKENED;
                } else
                {
                    return EffectIntensity.UNCHANGED;
                }
            }
            case FIRE:
            {
                if (other.elementType == ElementType.METAL)
                {
                    return EffectIntensity.STRENGTHENED;
                } else if (other.elementType == ElementType.WATER)
                {
                    return EffectIntensity.WEAKENED;
                } else
                {
                    return EffectIntensity.UNCHANGED;
                }
            }
            default:
            {
                return EffectIntensity.UNCHANGED;
            }
        }
    }

    public String toString()
    {
        return name + " - id: " + id + ", elementType: " + elementType + ", hp: " + hp + ", primarySkill: " + primarySkill.getSimpleName() + ", secondarySkill: " + secondarySkill.getSimpleName();
    }

    public String getId()
    {
        return this.id;
    }
    public void setId(String id)
    {
        this.id = id;
    }
    public ElementType getElementType()
    {
        return this.elementType;
    }
    public void setElementType(ElementType elementType)
    {
        this.elementType = elementType;
    }
    public int getHp()
    {
        if (hp <= 0)
        {
            this.hp = 0;
            return this.hp;
        } else
        {
            return this.hp;
        }
    }
    public void setHp(int hp)
    {
        if (hp <= 0)
        {
            this.hp = 0;
        } else
        {
            this.hp = hp;
        }
    }
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public Skill getPrimarySkill()
    {
        return this.primarySkill;
    }
    public void setPrimarySkill(Skill primarySkill)
    {
        this.primarySkill = primarySkill;
    }
    public Skill getSecondarySkill()
    {
        return this.secondarySkill;
    }
    public void setSecondarySkill(Skill secondarySkill)
    {
        this.secondarySkill = secondarySkill;
    }
    public void setPoints(int points)
    {
        this.points = points;
    }
    public void setParticipationCount(int participationCount)
    {
        this.participationCount = participationCount;
    }

    public int compareTo(Sprite other)
    {
        if (this.points > other.points)
        {
            return -1;
        } else if (this.points < other.points)
        {
            return 1;
        } else if (this.participationCount < other.participationCount)
        {
            return -1;
        } else if (this.participationCount > other.participationCount)
        {
            return 1;
        } else
        {
            return this.getId().compareTo(other.getId());
        }
    }

}
