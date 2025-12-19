package homework05.Sprite;

public enum EffectIntensity
{
    WEAKENED(-5),
    UNCHANGED(0),
    STRENGTHENED(5);

    private int value;

    private EffectIntensity(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return this.value;
    }
}
