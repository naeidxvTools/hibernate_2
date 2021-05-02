package net.imwork.zhanlong.hibernate26;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

/**
 * @author Administrator
 */
public class HibernateTest extends EmptyInterceptor
{
    public static void main(String[] args)
    {
//        save();
        select1();
        System.out.println(2222);
    }

    private static void select2()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();



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

    private static void select1()
    {
        Session session = HibernateUtil.openSession();

        Transaction tx = session.beginTransaction();

        Session session1 = HibernateUtil.openSession();

        Transaction tx1 = session1.beginTransaction();

        List<Student> list = session.createQuery("from Student ").list();

        for (Student student : list)
        {
            System.out.println(student.getName());
        }
        tx1.commit();

        System.out.println("===========================================");

        Session session2 = HibernateUtil.openSession();
        Transaction tx2 = session1.beginTransaction();
        System.out.println(session2.get(Student.class, "4028b881792c5e6d01792c5e72a6000a").getName());
        System.out.println(session2.get(Student.class, "4028b881792c5e6d01792c5e72a6000e").getName());

        tx2.commit();
        System.out.println("********************");

    }

    private static void save()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Team team = new Team();
            team.setTeamName("team2");

            for (int i = 0; i < 1200; i++)
            {
                Student student = new Student();
                student.setAge(30);
                student.setCardId("123456");
                student.setName((i + 1) + "student");
                student.setTeam(team);

                session.save(student);
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
}
