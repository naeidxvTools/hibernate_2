package net.imwork.zhanlong.hibernate15;

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

	@SuppressWarnings("unused")
	private static void save()
	{

		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction();

			Student student = new Student();

			student.setName("张三");
			student.setCardId("123456");
			student.setAge(30);

			session.save(student);

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
	}

	@SuppressWarnings("unused")
	private static void select()
	{
		Session session = HibernateUtil.getCurrentSession();
		Transaction tx = null;

		try
		{
			tx = session.beginTransaction();

			Student studentPrimaryKey = new Student();
			studentPrimaryKey.setCardId("123456");
			studentPrimaryKey.setName("张三");

			Student student = session.get(Student.class, studentPrimaryKey);
			System.out.println(student);

			tx.commit();
		}
		catch(Exception ex)
		{
			if(null != tx)
			{
				tx.rollback();
			}
		}
	}
}
