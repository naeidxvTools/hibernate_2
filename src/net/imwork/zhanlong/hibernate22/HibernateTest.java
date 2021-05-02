package net.imwork.zhanlong.hibernate22;

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
//        select_of_hql();
        select2();
    }

    private static void select2()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Query query = null;
        List list = null;
        try
        {
            tx = session.beginTransaction();

            //注意：设定了表的连接操作，覆盖了hbm文件中的lazy属性
            query = session.createQuery("from Team t join t.students");

//            Student student = (Student) session.createCriteria(Student.class)
//                    .add(Expression.eq("name", "tom"))
//                    .uniqueResult();
//            System.out.println(student);

            list = query.list();

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

        for (int i = 0; i < list.size(); i++)
        {
            Object[] objects = (Object[]) list.get(i);
            Team team = (Team) objects[0];
            Student student  = (Student)objects[1];
            System.out.println(team.getTeamName() + " : " + student.getName());
            System.out.println("------------------------------");
        }
    }


    /**
     * HQL检索方式
     */
    private static void select_of_hql()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
//**********************************************************************************************************
//            Query query = session.createQuery("select s.name, s.age from Student s");
//
//            List list = query.list();
//
//            for (int i = 0; i < list.size(); i++)
//            {
//                Object[] obj = (Object[]) list.get(i);
//
//                System.out.println(obj[0] + ", " + obj[1]);
//            }
//*********************************************************************************************************//
//            Query query = session.createQuery("select new Student(s.name,s.age) from Student s");
//
//            List<Student> list = query.list();
//
//            for (int i = 0; i < list.size(); i++)
//            {
//                Student student = list.get(i);
//                System.out.println(student.getName() + " = " + student.getAge() + ", " + student.getCardId());
//            }
//*********************************************************************************************************
//            Query query = session.createQuery("from Team t join t.students");
//            Query query = session.createQuery("from Team t left join t.students");
//            List list = query.list();
//
//            for (int i = 0; i < list.size(); i++)
//            {
//                Object[] objects = (Object[]) list.get(i);
//                Team team = (Team) objects[0];
//                Student student  = (Student)objects[1];
//                System.out.println(team.getTeamName() + " :: " + student.getName());
//                System.out.println("------------------------------");
//            }
//*********************************************************************************************************

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
            session.close();
        }
    }


    private static void save()
    {
        Session session = HibernateUtil.openSession();
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
        } finally
        {
            HibernateUtil.closeSession(session);
        }
    }
}
