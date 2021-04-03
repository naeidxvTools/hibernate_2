package net.imwork.zhanlong.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author 展龙
 */
public class HibernateUtil
{
    private static SessionFactory sessionFactory;

    static
    {
        try
        {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e)
        {
            e.printStackTrace();
        }
    }

    public static Session openSession()
    {
        return sessionFactory.openSession();
    }

    public static void closeSession(Session session)
    {
        if (null != session)
        {
            session.close();
        }
    }

}
