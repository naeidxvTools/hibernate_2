package net.imwork.zhanlong.event;

import org.hibernate.event.internal.DefaultSaveEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;

import java.io.Serializable;

public class MySaveListener extends DefaultSaveEventListener
{
    @Override
    protected Serializable performSaveOrUpdate(SaveOrUpdateEvent event)
    {
        System.out.println("performSaveOrUpdate(保存) invoked!!!");

        return super.performSaveOrUpdate(event);
    }
}















