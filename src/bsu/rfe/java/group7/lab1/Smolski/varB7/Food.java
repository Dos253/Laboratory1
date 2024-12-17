package bsu.rfe.java.group7.lab1.Smolski.varB7;

public abstract class Food implements Nutritious, Consumable
{
    // поле name, корое будут иметь наследники класса Food
    protected String name;


    public Food(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    // Переопределяем метод equals из класса Object
    @Override
    // Метод для сравнения текущего объекта с другим.
    // Возвращает true, сли объекты равны, и false в противном случае
    public boolean equals(Object obj)
    {
        // Проверка является ли переданный объект экземпляром класса Food
        if(!(obj instanceof Food))
        {
            return false;
        }

        //Проверяем, является ли миена одного из объектов null.
        // Если является то объекты не могут считаться равными
        if(name == null || ((Food)obj).name == null)
        {
            return false;
        }

        // Сравниваем имя текущего объекта с именем переданного объекта
        // Если имена равны возвращается true, иначе false
        return name.equals(((Food)obj).name);
    }

    @Override
    public String toString()
    {
        return name;
    }

}

