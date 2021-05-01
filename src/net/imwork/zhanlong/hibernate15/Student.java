package net.imwork.zhanlong.hibernate15;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Administrator
 *
 * 注意：1.复合主键类必须实现Serializable；2.复合主键类重写equal和hashCode方法。
 *      实现Serializable接口的原因：使用get或load方法的时候需要先构建出来该实体的对象，并且
 *      依据（联合主键）设置进去，然后作为get或load方法的第二个参数传进去即可。
 */
public class Student implements Serializable
{
    private String cardId;
    private String name;

    private int age;

    @Override
    public String toString()
    {
        return "Student{" +
                "cardId='" + cardId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getCardId()
    {
        return cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(cardId, student.cardId) &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(cardId, name);
    }
}
