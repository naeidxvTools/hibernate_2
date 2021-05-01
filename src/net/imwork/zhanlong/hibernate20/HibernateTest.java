package net.imwork.zhanlong.hibernate20;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;

/**
 * @author Administrator
 * 继承映射
 * 2.一张表存储继承体系中所有类的信息。
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
//                Person p = (Person) iterator.next();
//                System.out.println(p.getClass().getName());
//                System.out.println(p.getName());

                Person p = (Person) iterator.next();
                if (p instanceof Student)
                {
                    System.out.println(((Student)p).getCardId());
                }

                if (p instanceof Teacher)
                {
                    System.out.println(((Teacher)p).getSalary());
                }
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
