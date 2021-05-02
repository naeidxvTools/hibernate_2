package net.imwork.zhanlong.event;

import org.hibernate.HibernateException;
import org.hibernate.event.internal.DefaultLoadEventListener;
import org.hibernate.event.spi.LoadEvent;

public class MyLoadListener extends DefaultLoadEventListener
{
    @Override
    public void onLoad(LoadEvent event, LoadType loadType) throws HibernateException
    {
        super.onLoad(event,loadType); //这里必须显示调用父类的onLoad()
        System.out.println("hibernate 的监听器。(LoadEvent event,LoadType loadType)");

        System.out.println(event.getEntityId() + ", " + event.getEntityClassName());
    }



}























