package net.imwork.zhanlong.hibernate1;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author 展龙
 */
public class People
{
    private Long id;
    private String username;
    private String password;
    private long telephone;

    /**
     * 'M','F'
     */
    private char gender;
    private boolean graduation;
    private Date birthday;
    private Timestamp marryTime;
    private Blob file;
    private byte[] file2;

    public byte[] getFile2()
    {
        return file2;
    }

    public void setFile2(byte[] file2)
    {
        this.file2 = file2;
    }


    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public long getTelephone()
    {
        return telephone;
    }

    public void setTelephone(long telephone)
    {
        this.telephone = telephone;
    }

    public char getGender()
    {
        return gender;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }

    public boolean isGraduation()
    {
        return graduation;
    }

    public void setGraduation(boolean graduation)
    {
        this.graduation = graduation;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public Timestamp getMarryTime()
    {
        return marryTime;
    }

    public void setMarryTime(Timestamp marryTime)
    {
        this.marryTime = marryTime;
    }

    public Blob getFile()
    {
        return file;
    }

    public void setFile(Blob file)
    {
        this.file = file;
    }
}
