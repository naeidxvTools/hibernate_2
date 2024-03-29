package net.imwork.zhanlong.hibernate13;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Iterator;
import java.util.Set;

/**
 * @author Administrator
 */
public class HibernateTest
{
    public static void main(String[] args)
    {
//        save1();
        select();
    }

    private static void select()
    {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Team team = session.get(Team.class,"4028b881796febc201796febc5ff0000");

            Set set = team.getStudents();

            Iterator iterator = set.iterator();

            while (iterator.hasNext())
            {
                System.out.println(iterator.next());
            }



            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void save1()
    {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Team team = new Team();
            team.setTeamName("team1");

            team.getStudents().add("zhangsan");
            team.getStudents().add("lisi");
            team.getStudents().add("wangwu");

            session.save(team);

            tx.commit();
        } catch (Exception exception)
        {
            if (tx != null)
            {
                tx.rollback();
            }
            exception.printStackTrace();
        }
    }
}
