package net.imwork.zhanlong.hibernate8;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Map;

/**
 * @author Administrator
 */
public class HibernateTest
{
    public static void main(String[] args)
    {
        save1();
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

            Map map = team.getStudents();

            Student student1 = new Student();
            student1.setName("zhangsan");
            student1.setAge(20);
            student1.setTeam(team);

            Student student2 = new Student();
            student2.setName("lisi");
            student2.setAge(21);
            student2.setTeam(team);

            Student student3 = new Student();
            student3.setName("wangwu");
            student3.setAge(22);
            student3.setTeam(team);
            student3.setCardId("xxx");

            map.put("1111", student1);
            map.put("2222", student2);
            map.put("3333", student3);

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
