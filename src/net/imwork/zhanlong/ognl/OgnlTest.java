package net.imwork.zhanlong.ognl;

import ognl.Ognl;
import ognl.OgnlContext;
import ognl.OgnlException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OgnlTest
{
    public static void main(String[] args) throws OgnlException
    {
        Person person = new Person();
        person.setName("zhangsan");

        Dog dog = new Dog();
        dog.setName("wangcai");

        Dog dog2 = new Dog();
        dog2.setName("aaaa");
        person.setDog(dog2);

        OgnlContext context = new OgnlContext();

        context.put("person", person);
        context.put("dog", dog);
        context.setRoot(person);

        System.out.println(Ognl.parseExpression("name"));
        System.out.println(Ognl.getValue(Ognl.parseExpression("name"),context,context.getRoot()));
        System.out.println("=========================");
        System.out.println(Ognl.parseExpression("#person.name"));
        System.out.println(Ognl.getValue(Ognl.parseExpression("#person.name"),context,context.getRoot()));
        System.out.println("=========================");
        System.out.println(Ognl.parseExpression("#dog.name"));
        System.out.println(Ognl.getValue(Ognl.parseExpression("#dog.name"),context,context.getRoot()));
        System.out.println("=========================");
        System.out.println(Ognl.parseExpression("dog.name"));
        System.out.println(Ognl.getValue(Ognl.parseExpression("dog.name"),context,context.getRoot()));

        System.out.println("=========================");
        System.out.println(Ognl.getValue(Ognl.parseExpression("name.toUpperCase()"),context,context.getRoot()));
        System.out.println(Ognl.getValue(Ognl.parseExpression("toString()"), context, context.getRoot()));
        System.out.println(Ognl.getValue(Ognl.parseExpression("getClass()"),context, context.getRoot()));
        System.out.println(Ognl.getValue(Ognl.parseExpression("hashCode()"),context, context.getRoot()));
        Ognl.getValue(Ognl.parseExpression("show('zhanlong')"),context,context.getRoot());

        System.out.println("==========调用类的静态方法(其中Math可以省略)============");
        System.out.println(Ognl.getValue(Ognl.parseExpression("@java.lang.Integer@toBinaryString(10)"),context,context.getRoot()));
        System.out.println(Ognl.getValue(Ognl.parseExpression("@java.lang.Math@min(4,10)"),context,context.getRoot()));
        System.out.println(Ognl.getValue(Ognl.parseExpression("@@E"),context,context.getRoot()));
        System.out.println(Ognl.getValue(Ognl.parseExpression("@@PI"),context,context.getRoot()));


        System.out.println("==========可以new一个对象=====注意：Ognl中集合和数组一样======");
        Object o = Ognl.parseExpression("new net.imwork.zhanlong.ognl.MyClass('展龙').str");
        System.out.println(o);
        System.out.println(Ognl.getValue(o,context,context.getRoot()));
        System.out.println(Ognl.getValue(Ognl.parseExpression("new java.util.LinkedList().toString()"),context,context.getRoot()));
        System.out.println(Ognl.getValue("{'展龙','金立从','展梓千','喜洋洋'}[0]",context,context.getRoot()));
        System.out.println(Ognl.getValue("{'展龙','金立从','展梓千','喜洋洋'}.get(1)",context,context.getRoot()));

        dog.setFriends(new String[]{"小白","小黑","小花"});
        System.out.println(Ognl.getValue("#dog.friends[0]",context,context.getRoot()));

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("welcome");
        context.put("list", list);

        System.out.println(Ognl.getValue("#list[0]",context,context.getRoot()));
        System.out.println(Ognl.getValue("#list.get(1)",context,context.getRoot()));

        System.out.println("==========Ognl处理Map，其语法格式：#{'key1':'value1','key2':'value2',....}==========");
        Map<String, String> map = new HashMap<>();
        map.put("username", "zhangsan");
        map.put("password", "m123");
        context.put("map",map);
        System.out.println(Ognl.getValue(Ognl.parseExpression("#map['password']"),context,context.getRoot()));
        System.out.println(Ognl.getValue("#{'key1':'value1','key2':'value2'}['key2']",context,context.getRoot()));
        System.out.println(Ognl.getValue("#{'key1':'value1','key2':'value2'}",context,context.getRoot()));
        System.out.println(Ognl.getValue("#{'key1':'value1','key2':'value2'}.get('key2')",context,context.getRoot()));
        System.out.println(Ognl.getValue("#{'key1':'value1','key2':'value2'}.key1",context,context.getRoot()));

        System.out.println("==========Ognl运算，过滤：collection.{? expression}==========");
        List<Person> persons = new ArrayList<>();
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();

        Dog dog1 = new Dog();
        dog1.setName("hh");
        dog1.setFriends(new String[]{"hello...."});
        p2.setDog(dog1);

        p1.setName("zhangsan");
        p2.setName("lisi");
        p3.setName("wangwu");
        p1.setPassword("m123");
        p2.setPassword("m456");
        p3.setPassword("m789");
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        context.put("persons", persons);
        System.out.println(Ognl.getValue("#persons.{? #this.name.length() > 4}.size()",context,context.getRoot()));//#this代表#persons对象
        System.out.println(Ognl.getValue("#persons.{? #this.name.length() >= 4}[1].dog.friends[0]",context,context.getRoot()));
        System.out.println(Ognl.getValue("#persons.{? #this.name.length() > 4}.size",context,context.getRoot())); //size是伪属性
        System.out.println(Ognl.getValue("#persons.{? #this.name.length() > 4}.isEmpty()",context,context.getRoot()));
        System.out.println(Ognl.getValue("#persons.{? #this.name.length() > 4}.isEmpty",context,context.getRoot())); //isEmpty是伪属性
        System.out.println(Ognl.getValue("#persons.{? #this.name.length() > 4}[0]",context,context.getRoot())); //获取集合元素中的第一个元素(元素)
        System.out.println(Ognl.getValue("#persons.{? #this.name.length() > 4}",context,context.getRoot()));
        System.out.println(Ognl.getValue("#persons.{^ #this.name.length() > 4}",context,context.getRoot())); //获取集合中第一个元素（只有一个元素）的集合(集合)
        System.out.println(Ognl.getValue("#persons.{$ #this.name.length() > 4}.get(0).name",context,context.getRoot())); //获取集合中最后一个元素（只有一个元素）的集合(集合)

        System.out.println("==========Ognl运算，投影：collection.{expression}==========");
        System.out.println(Ognl.getValue("#persons.{#this.dog || name}",context,context.getRoot()));
        System.out.println(Ognl.getValue("#persons.{name}",context,context.getRoot()));
        System.out.println(Ognl.getValue("#persons.{#this.password}",context,context.getRoot()));
        System.out.println(Ognl.getValue("#persons.{password}",context,context.getRoot()));
        System.out.println(Ognl.getValue("#persons.{#this.name.length() <= 5 ? 'hello world' : #this.name}",context,context.getRoot()));
    }
}
