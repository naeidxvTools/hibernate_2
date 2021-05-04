package net.imwork.zhanlong.ognl;

public class MyClass
{
    private static String str;

    public static String getStr()
    {
        return str;
    }

    public static void setStr(String str)
    {
        MyClass.str = str;
    }

    public static String method()
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

