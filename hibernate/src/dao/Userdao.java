package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import model.user;

public class Userdao {
	
	
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session s=sf.openSession();
	Transaction tx=null;

	public boolean login(user user) {
		try {
			tx=s.beginTransaction();
			s.save(user);
			System.out.println("done");
			return true;
		}
		catch(Exception e) 
		{
			System.out.println(e.getMessage());

		}
		return false;
	}

}
