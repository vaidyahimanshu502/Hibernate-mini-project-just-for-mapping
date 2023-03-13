package com.hibernate.web.jdbc;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

/**
 * Hello world!
 *
 */
public class App  
{
    public static void main( String[] args )
    {
        System.out.println( "Project started...." );
  	
        Configuration cfg=  new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory= (SessionFactory)cfg.buildSessionFactory();
        System.out.println(factory);
        
        Student s1=new Student();
        s1.setId(1);
        s1.setName("Himanshu");
        s1.setCity("Chatra");
        Session session=((org.hibernate.SessionFactory) factory).openSession();
        Transaction tr=session.beginTransaction();
        session.save(s1);
        tr.commit();
        session.close();
    }
}
