package net.imwork.zhanlong.util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;

import java.util.EnumSet;

/**
 * @author 展龙
 */
public class CreateTable
{
    public static void main(String[] args)
    {
        //hibernate5中的schemaExport与之前版本中的用法有所不同，具体用法如下:
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg_mysql.xml").build();
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
//        SchemaExport export = new SchemaExport().setFormat(true); // 格式化sql语句
        SchemaExport export = new SchemaExport().setFormat(false);  // 不格式化sql语句
        export.create(EnumSet.of(TargetType.DATABASE), metadata);

        //hibernate3中的schemaExport用法
//        SchemaExport export = new SchemaExport(new Configuration().configure());
//        export.create(true, false);
    }

}
