package net.imwork.zhanlong.hibernate17;

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
//		save();
		select();


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

			Address address = new Address();
			address.setHomeAddress("黑龙江");
			address.setSchoolAddress("江西省九江");

			student.setAddress(address);

			session.saveOrUpdate(student);

			tx.commit();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
	}

	private static void select()
	{
		Session session = HibernateUtil.openSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();

			Student student = session.get(Student.class, "4028b8817926f1c2017926f1c6060000");
			System.out.println(student.getAddress().getHomeAddress());
			System.out.println(student.getAddress().getSchoolAddress());

			tx.commit();
		}
		catch(Exception ex)
		{
			if(null != tx)
			{
				tx.rollback();
			}
		}
		finally
		{
			HibernateUtil.closeSession(session);
		}
	}
}
