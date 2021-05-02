package net.imwork.zhanlong.hibernate25;

import java.util.Date;

/**
 * @author Administrator
 */
public class Student
{
    private String id;
    private String name;

    private String cardId;
    private int age;

    private Date lastDate;

    public Date getLastDate()
    {
        return lastDate;
    }

    public void setLastDate(Date lastDate)
    {
        this.lastDate = lastDate;
    }

    //    private int version;
//
//    public int getVersion()
//    {
//        return version;
//    }
//
//    public void setVersion(int version)
//    {
//        this.version = version;
//    }

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
}
