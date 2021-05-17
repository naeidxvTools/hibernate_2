package net.imwork.zhanlong.hibernate23;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;

/**
 * @author Administrator
 */
public class HibernateTest
{
    public static void main(String[] args)
    {
//        save();
        select();
    }


    /**
     * HQL检索方式
     */
    private static void select()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Team team = session.get(Team.class, "4028b881792a883201792a88358a0008");

//-------------------------------------------------------------------------------------------------------
//            Query query = session.createQuery("from Student s where s.team = :team and s.age > :age");
//            query.setParameter("team", team).setParameter("age",new Integer(20));  //对实体绑定参数第一种方式
////            query.setEntity("team", team).setParameter("age",new Integer(20));  //对实体绑定参数第二种方式

//---------------------------------createFilter 过滤器----------------------------------------------------
            Query query = (Query) session.createFilter(team.getStudents(), "where age > 20");

            List<Student> list = query.list();

            for (int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i).getName());
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

    @SuppressWarnings("unused")
    private static void save()
    {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Student student1 = new Student();
            student1.setName("tomclus");
            student1.setCardId("1");
            student1.setAge(25);
            student1.setCourses(new HashSet<>());

            Student student2 = new Student();
            student2.setName("tom");
            student2.setCardId("2");
            student2.setAge(25);
            student2.setCourses(new HashSet<>());

            Student student3 = new Student();
            student3.setName("spark");
            student3.setCardId("3");
            student3.setAge(25);
            student3.setCourses(new HashSet<>());

            Student student4 = new Student();
            student4.setName("jerry");
            student4.setCardId("4");
            student4.setAge(25);
            student4.setCourses(new HashSet<>());

            Course course1 = new Course();
            course1.setName("history");
            course1.setStudents(new HashSet<>());

            Course course2 = new Course();
            course2.setName("computer");
            course2.setStudents(new HashSet<>());

            Course course3 = new Course();
            course3.setName("music");
            course3.setStudents(new HashSet<>());

            Course course4 = new Course();
            course4.setName("ecnomic");
            course4.setStudents(new HashSet<>());

            Course course5 = new Course();
            course5.setName("politics");
            course5.setStudents(new HashSet<>());

            student1.getCourses().add(course1);
            student1.getCourses().add(course2);
            student1.getCourses().add(course3);

            student2.getCourses().add(course2);
            student2.getCourses().add(course4);

            student3.getCourses().add(course2);
            student3.getCourses().add(course3);

            course1.getStudents().add(student1);
            course2.getStudents().add(student1);
            course2.getStudents().add(student2);
            course2.getStudents().add(student3);
            course3.getStudents().add(student1);
            course3.getStudents().add(student3);
            course4.getStudents().add(student2);

            Team team = new Team();
            team.setTeamName("zc1901");
            team.getStudents().add(student1);
            team.getStudents().add(student2);


            Team team2 = new Team();
            team2.setTeamName("zc1902");
            team2.getStudents().add(student3);

            Team team3 = new Team();
            team3.setTeamName("zc1903");
            team3.getStudents().add(student4);

            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);
            session.save(team);
            session.save(team2);
            session.save(team3);
            session.save(course5);

            tx.commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();

            if (null != tx)
            {
                tx.rollback();
            }
        }
    }
}
