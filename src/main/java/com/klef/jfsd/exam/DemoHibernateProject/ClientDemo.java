package com.klef.jfsd.exam.DemoHibernateProject;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.Query;

public class ClientDemo {

	public static void main(String[] args) 
	{
		ClientDemo operations = new ClientDemo();
		boolean loop = true;
		while(loop)
		{
			System.out.println("Enter your option");
			Scanner sc = new Scanner(System.in);
			int opt = sc.nextInt();
			switch(opt) 
			{
			case 1: operations.addDepartment();
			break;
			case 2: operations.deletepositionalparams();
			break;
			}
		}

	}
	
	public void addDepartment()
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");       
		
		SessionFactory sf = configuration.buildSessionFactory();   
		Session session = sf.openSession();     
		
		Transaction t = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Department Name: ");
		String dname = sc.next();
		System.out.println("Enter Department Location: ");
		String dlocation = sc.next();
		System.out.println("Enter Department Hod: ");
		String dhod = sc.next();
		
		Department dept = new Department();
		dept.setName(dname);
		dept.setLocation(dlocation);
		dept.setHodName(dhod);
		
		
		session.persist(dept);
		t.commit();
		System.out.println("Department addedd successfully");
		
		session.close();
		sf.close();
	}
	
	
	public void deletepositionalparams()
	{
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");       
		
		SessionFactory sf = configuration.buildSessionFactory();   
		Session session = sf.openSession();     
		
		Transaction t = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Department ID: ");
		int did = sc.nextInt();
		
		
		String hql = "delete from Department where ID=?1";
		MutationQuery qry = session.createMutationQuery(hql);
		qry.setParameter(1, did);
		
		
		int n = qry.executeUpdate();
		
		t.commit();
		if(n>0) {
		System.out.println(n+" department(s) deleted successfully");
		}
		else {
			System.out.println("Department not found");
		}
		
		session.close();
		sf.close();
		
	}

}
