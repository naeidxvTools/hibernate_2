package net.imwork.zhanlong.ognl;

public class MyClass
{
    private String str;

    public String getStr()
    {
        return str;
    }

    public void setStr(String str)
    {
        this.str = str;
    }

    public String method()
    {
        return str + ": hello !";
    }

    public MyClass()
    {
    }

    public MyClass(String str)
    {
        this.str = str;
    }
}

