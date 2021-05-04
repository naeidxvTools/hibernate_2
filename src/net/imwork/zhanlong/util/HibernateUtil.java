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
            sessionFactory = new Configuration().configure("hibernate.cfg_mysql.xml").buildSessionFactory();

            //设置SessionFactory的拦截器(拦截器用的比较少)
//            sessionFactory = new Configuration().configure("hibernate.cfg_sqlserver.xml").setInterceptor(new HibernateTest())
//                    .buildSessionFactory();
        } catch (HibernateException e)
        {
            e.printStackTrace();
        }
    }

    public static Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }

    public static Session openSession()
    {
        //设置session的拦截器(拦截器用的比较少)
//        Session session_interceptor = sessionFactory.withOptions().
//                interceptor(new HibernateTest()).openSession();

        Session session = sessionFactory.openSession();

        return session;
    }

    public static void closeSession(Session session)
    {
        if (null != session)
        {
            session.close();
        }
    }

}
