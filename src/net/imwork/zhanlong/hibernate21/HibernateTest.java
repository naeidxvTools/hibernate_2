package net.imwork.zhanlong.hibernate21;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;

/**
 * @author Administrator
 * 继承映射
 * 3.公共信息放在父类表中，独有信息放在子类表中，每个子类对应一张表。
 */
public class HibernateTest
{

    public static void main(String[] args)
    {
//        save();
        select();
    }

    private static void select()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();

            Query query = session.createQuery("from Person ");

            Iterator iterator = query.list().iterator();

            while (iterator.hasNext())
            {
                Person p = (Person) iterator.next();
                System.out.println(p.getName());
            }



            tx.commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            if (null != tx)
            {
                tx.rollback();
            }
        } finally
        {
            HibernateUtil.closeSession(session);
        }
    }

    private static void save()
    {

        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();

            Student student = new Student();
            student.setCardId("123456");
            student.setName("zhangsan");

            Teacher teacher = new Teacher();
            teacher.setSalary(100);
            teacher.setName("lisi");

            session.saveOrUpdate(teacher);
            session.saveOrUpdate(student);

            tx.commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            if (null != tx)
            {
                tx.rollback();
            }
        } finally
        {
            HibernateUtil.closeSession(session);
        }
    }


}
