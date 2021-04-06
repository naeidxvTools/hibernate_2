package net.imwork.zhanlong.hibernate2;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;

/**
 * @author 展龙
 */
public class HibernateTest
{
    public static void main(String[] args)
    {
        saveCustomerOrder();

    }

    public static void saveCustomerOrder()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;


        try
        {
            tx = session.beginTransaction();

            Customer customer = new Customer();
            customer.setName("lisi");
            customer.setOrders(new HashSet<Order>());

            Order order1 = new Order();
            order1.setOrderNumber("order4");
            Order order2 = new Order();
            order2.setOrderNumber("order5");
            Order order3 = new Order();
            order3.setOrderNumber("order6");

            order1.setCustomer(customer);
            order2.setCustomer(customer);
            order3.setCustomer(customer);

            customer.getOrders().add(order1);
            customer.getOrders().add(order2);
            customer.getOrders().add(order3);

            session.save(customer);

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
