package net.imwork.zhanlong.hibernate6;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
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

    private static void select2()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Student student = session.get(Student.class, "4028b88178bbc4110178bbc414370000");
            Course course = session.get(Course.class, "4028b88178bbcd9e0178bbcda1830001");

            student.getCourses().add(course);
            course.getStudents().add(student);


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

    private static void select1()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Student student = session.get(Student.class, "4028b88178bbc4110178bbc414370000");
            System.out.println(student.getName());

            Set<Course> set = student.getCourses();

            for (Course c : set)
            {
                System.out.println(c.getName());
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

            Student student = new Student();
            student.setName("zhangsan");

            Course course = new Course();
            course.setName("math");

            student.setCourses(new HashSet<>());
            course.setStudents(new HashSet<>());

            student.getCourses().add(course);
            course.getStudents().add(student);

            session.save(student);



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
