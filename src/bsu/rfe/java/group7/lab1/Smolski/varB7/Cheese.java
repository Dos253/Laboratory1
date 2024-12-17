package bsu.rfe.java.group7.lab1.Smolski.varB7;

public class Cheese extends Food
{
    public Cheese()
    {
        super("Сыр");
    }
    public void consume()
    {
        System.out.println(this + " съеден");
    }
    
    @Override
    public int calculateCalories()
    {
        return 300;
    }
}
