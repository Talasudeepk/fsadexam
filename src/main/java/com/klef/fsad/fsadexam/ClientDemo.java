package com.klef.fsad.fsadexam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ClientDemo {

public static void main(String[] args) {

Configuration cfg = new Configuration();
cfg.configure("hibernate.cfg.xml");

SessionFactory sf = cfg.buildSessionFactory();
Session session = sf.openSession();

Transaction tx = session.beginTransaction();

/* Insert Operation */

Library l = new Library("Java Book","Programming","10-03-2026","Available");
session.save(l);

System.out.println("Record Inserted");

/* Delete Operation */

Library obj = session.get(Library.class,1);

if(obj!=null){
session.delete(obj);
System.out.println("Record Deleted");
}

tx.commit();

session.close();
sf.close();

}
}