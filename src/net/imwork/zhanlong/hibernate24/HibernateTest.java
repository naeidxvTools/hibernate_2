package net.imwork.zhanlong.hibernate24;

import net.imwork.zhanlong.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author Administrator
 *      QBC检索方式
 */
public class HibernateTest
{
    public static void main(String[] args)
    {
//        save();
        select2();
    }

    private static void select1()
    {
        Session session = HibernateUtil.openSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            //QBC查询

//            Criteria criteria = session.createCriteria(Student.class).
//                    add(Restrictions.between("age",20,30));

//            Criteria criteria = session.createCriteria(Student.class).
//                    add(Restrictions.like("name","t%"));

//            String[] names = {"jerry","spark","tom","aa"};
//            Criteria criteria = session.createCriteria(Student.class).
//                    add(Restrictions.in("name",names));

            Criteria criteria = session.createCriteria(Student.class).
                    addOrder(Order.asc("age")).addOrder(Order.desc("cardId"));

            List<Student> list = criteria.list();

            for (int i = 0; i < list.size(); i++)
            {
                System.out.println(list.get(i).getName());
            }

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

    private static void select2()
    {
        //1.创建Session对象
        Session session = HibernateUtil.getCurrentSession();

        //2.创建CriteriaBuilder对象
        CriteriaBuilder builder = session.getCriteriaBuilder();

        //3.获取CriteriaQuery对象
        CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);

        //4.指定根条件
        criteriaQuery.from(Student.class);

        //5.执行查询
        Query<Student> query = session.createQuery(criteriaQuery);

        //6.返回查询结果集
        List<Student> resultList = query.getResultList();
        Iterator<Student> iterator = resultList.iterator();
        while (iterator.hasNext())
        {
            Student student = iterator.next();
            System.out.println(student.getName() + ", " + student.getAge() + ", " + student.getCardId());
            System.out.println("=================================");
        }
    }

    private static void save()
    {
        Session session = HibernateUtil.getCurrentSession();
        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Student student1 = new Student();
            student1.setName("tomclus");
            student1.setCardId("1");
            student1.setAge(25);
            student1.setCourses(new HashSet<>());

            Student student2 = new Student();
            student2.setName("tom");
            student2.setCardId("2");
            student2.setAge(25);
            student2.setCourses(new HashSet<>());

            Student student3 = new Student();
            student3.setName("spark");
            student3.setCardId("3");
            student3.setAge(25);
            student3.setCourses(new HashSet<>());

            Student student4 = new Student();
            student4.setName("jerry");
            student4.setCardId("4");
            student4.setAge(25);
            student4.setCourses(new HashSet<>());

            Course course1 = new Course();
            course1.setName("history");
            course1.setStudents(new HashSet<>());

            Course course2 = new Course();
            course2.setName("computer");
            course2.setStudents(new HashSet<>());

            Course course3 = new Course();
            course3.setName("music");
            course3.setStudents(new HashSet<>());

            Course course4 = new Course();
            course4.setName("ecnomic");
            course4.setStudents(new HashSet<>());

            Course course5 = new Course();
            course5.setName("politics");
            course5.setStudents(new HashSet<>());

            student1.getCourses().add(course1);
            student1.getCourses().add(course2);
            student1.getCourses().add(course3);

            student2.getCourses().add(course2);
            student2.getCourses().add(course4);

            student3.getCourses().add(course2);
            student3.getCourses().add(course3);

            course1.getStudents().add(student1);
            course2.getStudents().add(student1);
            course2.getStudents().add(student2);
            course2.getStudents().add(student3);
            course3.getStudents().add(student1);
            course3.getStudents().add(student3);
            course4.getStudents().add(student2);

            Team team = new Team();
            team.setTeamName("zc1901");
            team.getStudents().add(student1);
            team.getStudents().add(student2);


            Team team2 = new Team();
            team2.setTeamName("zc1902");
            team2.getStudents().add(student3);

            Team team3 = new Team();
            team3.setTeamName("zc1903");
            team3.getStudents().add(student4);

            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);
            session.save(team);
            session.save(team2);
            session.save(team3);
            session.save(course5);

            tx.commit();
        } catch (Exception ex)
        {
            ex.printStackTrace();

            if (null != tx)
            {
                tx.rollback();
            }
        }
    }
}
