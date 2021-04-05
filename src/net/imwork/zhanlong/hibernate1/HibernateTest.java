package net.imwork.zhanlong.hibernate1;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

/**
 * @author 展龙
 */
public class HibernateTest
{
    public static void main(String[] args) throws Exception
    {
//         savePeople();
//         savePeople();
//         savePeople();

//        selectPeople();
        deletePeople();
    }

    public static void deletePeople()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        List<People> peoples = null;
        Iterator<People> iterate = null;
        try
        {
            tx = session.beginTransaction();

            Query<People> query = session.createQuery("from People ");

            // 1.调用Query的list()方法
//            peoples = query.list();
//            for (People p : peoples)
//            {
//                session.delete(p);
//            }

            // 2.调用Query的iterate()方法
            iterate = query.iterate();
//            while (iterate.hasNext())
//            {
//                session.delete(iterate.next());
//            }
            tx.commit();
        }catch (Exception ex)
        {
            if (null != tx)
            {
                tx.rollback();
            }
        }finally
        {
            HibernateUtil.closeSession(session);
        }

//        for (Iterator<People> iterator = peoples.iterator(); iterator.hasNext();)
//        {
//            System.out.println(iterator.next().getUsername());
//        }
//        while (iterate.hasNext())
//        {
//            System.out.println(iterate.next());
//        }

    }

    public static void selectPeople()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            Query query = session.createQuery("from People ").setFirstResult(1).setMaxResults(5);

            List<People> peoples = query.list();
            Iterator iterate = query.iterate();

            for (People p : peoples)
            {
                System.out.println(p.getUsername());
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

    public static void savePeople() throws Exception
    {
        People people = new People();
        people.setUsername("展龙");
        people.setPassword("m123");
        people.setGender('F');
        people.setBirthday(new java.sql.Date(new java.util.Date().getTime()));
        people.setTelephone(15949586683L);
        people.setMarryTime(new Timestamp(new java.util.Date().getTime()));

        InputStream is = new FileInputStream("e:/qianqian.mp4");
        int length = is.available();
        byte[] buffer = new byte[length];
        is.read(buffer);
        people.setFile2(buffer);

        Session session = HibernateUtil.openSession();
        InputStream is2 = new FileInputStream("e:/qianqian.mp4");
        Blob blob = Hibernate.getLobCreator(session).createBlob(is2, is2.available());
        people.setFile(blob);

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();
            session.save(people);
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
