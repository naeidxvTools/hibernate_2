package net.imwork.zhanlong.hibernate1;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Timestamp;

/**
 * @author 展龙
 */
public class HibernateTest
{
    public static void main(String[] args) throws Exception
    {
        People people = new People();
        people.setUsername("展龙");
        people.setPassword("m123");
        people.setGender('F');
        people.setBirthday(new java.sql.Date(new java.util.Date().getTime()));
        people.setTelephone(15949586683L);
        people.setMarryTime(new Timestamp(new java.util.Date().getTime()));

        InputStream is = new FileInputStream("e:/qianqian.mp4");

//        int length = is.available();
//        byte[] buffer = new byte[length];
//        is.read(buffer);
        Session session = HibernateUtil.openSession();
        Blob blob = Hibernate.getLobCreator(session).createBlob(is, is.available());
        people.setFile(blob);
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
