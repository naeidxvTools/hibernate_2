package net.imwork.zhanlong.hibernate4;

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
        saveStudentIdCard();
//        selectStudentIdCard();
//       deleteStudentIdCard();
    }

    private static void deleteStudentIdCard()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Student student = null;
        IdCard idCard = null;
        try
        {
            tx = session.beginTransaction();

            student = session.get(Student.class, "4028b88178b68e5b0178b68e5e450000");
            session.delete(student);

            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }finally
        {
            HibernateUtil.closeSession(session);
        }
    }

    private static void updateStudentIdCard()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Student student = null;
        IdCard idCard = null;
        try
        {
            tx = session.beginTransaction();

            student = session.get(Student.class, "4028b88178b68e5b0178b68e5e450000");

            student.setName("金立从");

            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }finally
        {
            HibernateUtil.closeSession(session);
        }
    }


    private static void selectStudentIdCard()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        Student student = null;
        IdCard idCard = null;
        try
        {
            tx = session.beginTransaction();

            student = session.get(Student.class, "4028b88178b68e5b0178b68e5e450000");


            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }finally
        {
            HibernateUtil.closeSession(session);
        }

        System.out.println(student.getName());
        System.out.println(student.getIdCard().getNumber());

    }

    public static void saveStudentIdCard()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;


        try
        {
            tx = session.beginTransaction();

            Student student = new Student();
            student.setName("展龙");

            IdCard idCard = new IdCard();
            idCard.setNumber(123456);

            student.setIdCard(idCard);
            idCard.setStudent(student);

            session.save(student);


            tx.commit();
        } catch (Exception e)
        {
            if (null != tx)
            {
                tx.rollback();
            }
            e.printStackTrace();
        }finally
        {
            HibernateUtil.closeSession(session);
        }

    }
}
