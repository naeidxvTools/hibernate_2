package net.imwork.zhanlong.hibernate24;

import java.util.Set;

/**
 * @author Administrator
 */
public class Course
{
    private String id;
    private String name;

    private Set<Student> students;

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

    public Set<Student> getStudents()
    {
        return students;
    }

    public void setStudents(Set<Student> students)
    {
        this.students = students;
    }
}
