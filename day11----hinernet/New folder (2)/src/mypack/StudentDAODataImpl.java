package mypack;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAODataImpl implements StudentDAO
{
     public void addStudent(Student s)
     {
    	 try
    	 {
    		 Session session=HibernateUtil.getSessionFactory().openSession();
    		 Transaction transaction=session.beginTransaction();
    		 session.save(s);
    		 transaction.commit();
    		 session.close();
    	 }
    	 catch(Exception e)
    	 {e.printStackTrace();}
     }
}
