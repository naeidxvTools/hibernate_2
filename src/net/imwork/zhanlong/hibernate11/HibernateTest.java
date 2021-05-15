package net.imwork.zhanlong.hibernate11;

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
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Team team1 = new Team();
            team1.setTeamName("team1");

            Team team2 = new Team();
            team2.setTeamName("team2");

            Student student1 = new Student();
            student1.setName("zhangsan");
            student1.setAge(12);
            student1.setCardId("123456");
            student1.setTeam(team1);

            Student student2 = new Student();
            student2.setName("lisi");
            student2.setAge(22);
            student2.setCardId("654321");
            student2.setTeam(team1);

            Student student3 = new Student();
            student3.setName("wangwu");
            student3.setAge(32);
            student3.setCardId("55555");
            student3.setTeam(team2);

            team1.getStudents().add(student1);
            team1.getStudents().add(student2);
            team2.getStudents().add(student3);

            session.save(team1);
            session.save(team2);

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
