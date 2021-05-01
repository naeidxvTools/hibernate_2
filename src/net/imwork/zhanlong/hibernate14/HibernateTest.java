package net.imwork.zhanlong.hibernate14;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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

			Team team = new Team();
			team.setName("zc0901");
			team.setStudents(new HashSet<>());

			Student student1 = new Student();
			student1.setName("zhangsan");
			student1.setAge(11);
			student1.setCardId("123");
			student1.setTeam(team);

			Student student2 = new Student();
			student2.setName("lisi");
			student2.setAge(15);
			student2.setCardId("456");
			student2.setTeam(team);

			Student student3 = new Student();
			student3.setName("wangwu");
			student3.setAge(8);
			student3.setCardId("654");
			student3.setTeam(team);

			Student student4 = new Student();
			student4.setName("zhaoliu");
			student4.setAge(16);
			student4.setCardId("321");
			student4.setTeam(team);

			Student student5 = new Student();
			student5.setName("niuqi");
			student5.setAge(13);
			student5.setCardId("789");
			student5.setTeam(team);

			team.getStudents().add(student1);
			team.getStudents().add(student2);
			team.getStudents().add(student3);
			team.getStudents().add(student4);
			team.getStudents().add(student5);

			session.save(team);

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

			Team team = (Team)session.get(Team.class, "4028b8817925bfe0017925bfe3f00000");

			Set<Student> set = team.getStudents();

			for(Iterator<Student> iter = set.iterator(); iter.hasNext();)
			{
				System.out.println(iter.next().getName());
			}

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
