package net.imwork.zhanlong.hibernate16;

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
			StudentPrimaryKey studentPrimaryKey = new StudentPrimaryKey();
			studentPrimaryKey.setName("李四");
			studentPrimaryKey.setCardId("654321");

			student.setAge(30);
			student.setStudentPrimaryKey(studentPrimaryKey);

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
			ex.printStackTrace();
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

			StudentPrimaryKey studentPrimaryKey = new StudentPrimaryKey();
			studentPrimaryKey.setCardId("654321");
			studentPrimaryKey.setName("李四");

			Student student = session.get(Student.class, studentPrimaryKey);
			System.out.println(student.getAge());

			tx.commit();
		}
		catch(Exception ex)
		{
			if(null != tx)
			{
				tx.rollback();
			}
			ex.printStackTrace();
		}
	}
}
