package net.imwork.zhanlong.hibernate22;

import java.util.Set;

/**
 * @author Administrator
 */
public class Student
{
    private String id;
    private String name;

    private String cardId;
    private int age;
    private Set<Course> courses;

    public Student(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Student()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getCardId()
    {
        return cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Set<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(Set<Course> courses)
    {
        this.courses = courses;
    }
}
