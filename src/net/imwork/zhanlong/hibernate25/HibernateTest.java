package net.imwork.zhanlong.hibernate25;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Administrator
 */
public class HibernateTest extends EmptyInterceptor
{
    public static void main(String[] args)
    {
//        save();
        select_version();
    }

    private static void select_version()
    {
        /*
        Session session1 = HibernateUtil.openSession();
        Session session2 = HibernateUtil.openSession();

        Student student1 = (Student) session1.createQuery("from Student s where s.name = :name")
                .setParameter("name", "zhangsan").uniqueResult();

        Student student2 = (Student) session2.createQuery("from Student s where name = :name")
                .setParameter("name", "zhangsan").uniqueResult();

        System.out.println(student1.getVersion());
        System.out.println(student2.getVersion());

        Transaction tx1 = session1.beginTransaction();
        student1.setName("lisi");
        tx1.commit();

        System.out.println(student1.getVersion());
        System.out.println(student2.getVersion());

        Transaction tx2 = session2.beginTransaction();
        student2.setName("wangwu");
        tx2.commit();

        HibernateUtil.closeSession(session1);
        HibernateUtil.closeSession(session2);
*/
    }

    private static void save()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Student student = new Student();
            student.setName("zhangsan");
            student.setCardId("123456");
            student.setAge(20);

            session.save(student);

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
