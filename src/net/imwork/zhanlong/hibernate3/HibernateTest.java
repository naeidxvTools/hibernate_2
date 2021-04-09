package net.imwork.zhanlong.hibernate3;

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

//        saveCategories();

        selectCategories();


    }

    public static void selectCategories()
    {
        Session session = HibernateUtil.openSession();

        Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Category category = session.get(Category.class, new Long(1));

            System.out.println(category.getName());

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

    public static void saveCategories()
    {
          Session session = HibernateUtil.openSession();
          Transaction tx = null;

        try
        {
            tx = session.beginTransaction();

            Category category1 = new Category("level1", null, new HashSet<Category>());
            Category category2 = new Category("level2", null, new HashSet<Category>());
            Category category3 = new Category("level2", null, new HashSet<Category>());
            Category category4 = new Category("level3", null, new HashSet<Category>());
            Category category5 = new Category("level3", null, new HashSet<Category>());
            Category category6 = new Category("level3", null, new HashSet<Category>());
            Category category7 = new Category("level3", null, new HashSet<Category>());

            category2.setParentCategory(category1);
            category3.setParentCategory(category1);

            category1.getChildCategories().add(category2);
            category1.getChildCategories().add(category3);

            category4.setParentCategory(category2);
            category5.setParentCategory(category2);

            category2.getChildCategories().add(category4);
            category2.getChildCategories().add(category5);

            category6.setParentCategory(category3);
            category7.setParentCategory(category3);

            category3.getChildCategories().add(category6);
            category3.getChildCategories().add(category7);

            session.save(category1);
            session.load(Category.class, new Long(1));

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
