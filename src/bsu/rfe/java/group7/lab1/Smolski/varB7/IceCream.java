package bsu.rfe.java.group7.lab1.Smolski.varB7;

public class IceCream extends Food
{
    private String syrup;

    public IceCream(String syrup)
    {
        super("Мороженое");
        this.syrup = syrup;
    }

    public String getSyrup()
    {
        return syrup;
    }

    public void consume()
    {
        System.out.println(this + " съедено");
    }

    @Override
    public int calculateCalories() {
        int calories = 0;
        String[] syrups = syrup.split(" и "); // Разделяем сиропы

        for (String s : syrups) {
            if (s.equals("карамель")) {
                calories += 200;
            } else if (s.equals("шоколад")) {
                calories += 250;
            }
        }
        return calories;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }

        if (!(obj instanceof IceCream)) {
            return false;
        }

        return syrup.equals(((IceCream) obj).syrup);
    }
}
