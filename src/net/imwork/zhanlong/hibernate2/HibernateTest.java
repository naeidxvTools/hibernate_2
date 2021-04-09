package net.imwork.zhanlong.hibernate2;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 展龙
 */
public class HibernateTest
{
    public static void main(String[] args)
    {
//        saveCustomerOrder();
        deleteCustomerOrder();

    }

    private static void deleteCustomerOrder()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        Customer customer = null;

        try
        {
            tx = session.beginTransaction();
            customer = session.get(Customer.class, new Long(2));

            session.delete(customer);

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

    public static void selectCustomerOrder2()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        Order order = null;

        try
        {
            tx = session.beginTransaction();

            order = session.get(Order.class, new Long(1));

            System.out.println(order.getOrderNumber());

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

        System.out.println(order.getCustomer().getName());
    }

    public static void selectCustomerOrder()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        Customer customer = null;
        Set<Order> orders = null;

        try
        {
            tx = session.beginTransaction();
            customer = session.get(Customer.class, new Long(1));

            System.out.println(customer.getName());

            orders = customer.getOrders();
            System.out.println(orders.getClass());

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



//        System.out.println("after : " + customer.getName());
//
//        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();)
//        {
//            System.out.println(iterator.next().getOrderNumber());
//        }

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
