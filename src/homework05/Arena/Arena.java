package homework05.Arena;

import homework05.Battle.Battle;
import homework05.Battle.BattleOutcome;
import homework05.Sprite.Sprite;

import java.util.ArrayList;
import java.util.Collections;

public class Arena
{
    private ArrayList<Sprite> sprites;
    private ArrayList<Battle> battles;

    public Arena()
    {
        this.sprites = new ArrayList<>();
        this.battles = new ArrayList<>();
    }

    public ArrayList<Sprite> getSprites()
    {
        return this.sprites;
    }
    public void setSprites(ArrayList<Sprite> sprites)
    {
        this.sprites = sprites;
    }
    public ArrayList<Battle> getBattles()
    {
        return this.battles;
    }
    public void setBattles(ArrayList<Battle> battles)
    {
        this.battles = battles;
    }

    public boolean addBattle(Battle battle)
    {
        if (battle.getHomeSprite().getId().equals(battle.getAwaySprite().getId()))
        {
            return false;
        }
        if (sprites.contains(battle.getHomeSprite()) && sprites.contains(battle.getAwaySprite()))
        {
            battles.add(battle);
            return true;
        } else
        {
            return false;
        }
    }

    public void reset()
    {
        for (int i = 0; i < sprites.size(); i++)
        {
            sprites.get(i).setPoints(0);
            sprites.get(i).setParticipationCount(0);
        }
    }

    public void beginFreeForAllBattle()
    {
        reset();
        for (int i = 0; i < battles.size(); i++)
        {
            BattleOutcome result = battles.get(i).begin1v1Battle();
            battles.get(i).getHomeSprite().points += result.getValue();
            battles.get(i).getAwaySprite().points += (2 - result.getValue());
            battles.get(i).getHomeSprite().participationCount++;
            battles.get(i).getAwaySprite().participationCount++;
        }
    }

    public void show()
    {
        Collections.sort(sprites);
        for (int i = 0; i < sprites.size(); i++)
        {
            Sprite sprite = sprites.get(i);
            System.out.println(sprite.getName() + " " + sprite.getId() + " " + sprite.points + " " + sprite.participationCount);
        }
    }
}
