package net.imwork.zhanlong.hibernate18;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 *
 */
public class Student
{
    private String id;
    private String name;

    private Set contacts = new HashSet();

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

    public Set getContacts()
    {
        return contacts;
    }

    public void setContacts(Set contacts)
    {
        this.contacts = contacts;
    }
}
