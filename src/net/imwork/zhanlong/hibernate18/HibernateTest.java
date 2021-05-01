package net.imwork.zhanlong.hibernate18;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Set;

/**
 * @author Administrator
 */
public class HibernateTest
{

	public static void main(String[] args)
	{
		save();
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

			Contact contact1 = new Contact();
			contact1.setMethod("telephone");
			contact1.setAddress("beijing");

			Contact contact2 = new Contact();
			contact2.setMethod("address");
			contact2.setAddress("jiujiang");

			Set students = student.getContacts();

			students.add(contact1);
			students.add(contact2);

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


}
