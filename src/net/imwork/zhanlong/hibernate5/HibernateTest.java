package net.imwork.zhanlong.hibernate5;


import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;

/**
 * @author Administrator
 */
public class HibernateTest
{
    public static void main(String[] args)
    {
//        save1();
        select1();
    }

    private static void select1()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;


        try
        {
            tx = session.beginTransaction();

            Team team = session.get(Team.class, "4028b88178bba3210178bba324910000");

            System.out.println(team.getName());


            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }finally
        {
            HibernateUtil.closeSession(session);
        }
    }


    public static void save1()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;


        try
        {
            tx = session.beginTransaction();

            Student student = new Student();
            student.setName("展龙");

            IdCard idCard = new IdCard();
            idCard.setNumber(123456);

            student.setIdCard(idCard);
            idCard.setStudent(student);

            Team team = new Team();
            team.setName("team1");

            team.setStudents(new HashSet<Student>());
            team.getStudents().add(student);

            student.setTeam(team);

            session.save(team);


            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }finally
        {
            HibernateUtil.closeSession(session);
        }

    }
}
