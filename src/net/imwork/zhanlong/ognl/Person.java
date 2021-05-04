package net.imwork.zhanlong.ognl;

public class Person
{
    private String name;
    private String password;

    private Dog dog;

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void show(String str)
    {
        System.out.println(str + ": show invoked!");
    }

    public Dog getDog()
    {
        return dog;
    }

    public void setDog(Dog dog)
    {
        this.dog = dog;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
