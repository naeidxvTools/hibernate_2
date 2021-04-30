package net.imwork.zhanlong.hibernate12;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

            Team team = (Team) session.createQuery("from Team t where t.teamName = 'team1'").uniqueResult();

            Map map = team.getStudents();

            Set set = map.keySet();

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
        } finally
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

            Team team = new Team();
            team.setTeamName("team1");

            team.getStudents().put("展龙", "1班的");
            team.getStudents().put("金立从", "2班的");
            team.getStudents().put("展梓千", "3班的");
            team.getStudents().put("张三", "4班的");
            team.getStudents().put("李四", "5班的");
            team.getStudents().put("zhangsan", "6班的");
            team.getStudents().put("lisi", "7班的");

            session.save(team);


            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        } finally
        {
            HibernateUtil.closeSession(session);
        }

    }
}
