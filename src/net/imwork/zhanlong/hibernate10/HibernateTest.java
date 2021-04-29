package net.imwork.zhanlong.hibernate10;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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

            Student student1 = new Student();
            student1.setName("zhangsan");
            student1.setAge(12);
            student1.setCardId("123456");
            student1.setTeam(team);

            Student student2 = new Student();
            student2.setName("lisi");
            student2.setAge(22);
            student2.setCardId("654321");
            student2.setTeam(team);

            Student student3 = new Student();
            student3.setName("wangwu");
            student3.setAge(32);
            student3.setCardId("55555");
            student3.setTeam(team);

            List list = team.getStudents();
            list.add(student1);
            list.add(student2);
            list.add(student3);

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
