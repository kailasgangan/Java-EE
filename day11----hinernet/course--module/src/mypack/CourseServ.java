package mypack;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Servlet implementation class CourseServ
 */
@WebServlet("/CourseServ")
public class CourseServ extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Course c1=new Course();
		Module m1=new Module();
		Module m2=new Module();
		Module m3=new Module();
		c1.setName(request.getParameter("cname"));
		m1.setName(request.getParameter("module1"));
		m2.setName(request.getParameter("module2"));
		m3.setName(request.getParameter("module3"));
		Set<Module> myset=new HashSet<Module>();
		myset.add(m1);
		myset.add(m2);
		myset.add(m3);
		c1.setModules(myset);
		try
		{
			Session session= HibernateUtil.getSessionFactory().openSession();
			Transaction transaction=session.beginTransaction();
			session.save(c1);
			transaction.commit();
		}
		catch(Exception e)
		{e.printStackTrace();}
		RequestDispatcher rd=request.getRequestDispatcher("ShowServ");
		rd.forward(request, response);
	}

}
