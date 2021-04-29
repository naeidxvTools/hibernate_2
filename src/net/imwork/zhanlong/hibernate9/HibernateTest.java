package net.imwork.zhanlong.hibernate9;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Administrator
 */
public class HibernateTest
{
    public static void main(String[] args)
    {
        Session session = HibernateUtil.openSession();

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
        }finally
        {
            HibernateUtil.closeSession(session);
        }
    }
}
