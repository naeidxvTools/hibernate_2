package net.imwork.zhanlong.hibernate19;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Iterator;

/**
 * @author Administrator
 * 继承映射
 * 1.每个子类一张表
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

            /**
             * 多态查询
             */
            Query query = session.createQuery("from net.imwork.zhanlong.hibernate19.Person");

            Iterator iterator = query.iterate();

            while (iterator.hasNext())
            {
                Person p = (Person)iterator.next();
                System.out.println(p.getClass().getName());
                System.out.println(p.getName());
            }
            System.out.println("=====================================");

            Query query1 = session.createQuery("from java.lang.Object");

            Iterator iterator1 = query1.list().iterator();

            while (iterator1.hasNext())
            {
                System.out.println(iterator1.next());
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
