package net.imwork.zhanlong.hibernate16;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Administrator
 * 注意：1.复合主键类必须实现Serializable；2.复合主键类重写equal和hashCode方法。
 *      将主键锁对应属性提取出一个类（称之为主键类），并且主键类需要实现Serializable接口，重写equal和hashCode方法。
 */
public class StudentPrimaryKey implements Serializable
{
    private String cardId;
    private String name;

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
        StudentPrimaryKey that = (StudentPrimaryKey) o;
        return Objects.equals(cardId, that.cardId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(cardId, name);
    }
}
