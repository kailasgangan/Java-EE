package mypack;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Servlet implementation class ShowServ
 */
@WebServlet("/ShowServ")
public class ShowServ extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Session session=HibernateUtil.getSessionFactory().openSession();
		Query<?> query=session.createQuery("from Course");
		List<Course> mylist=(List<Course>)query.list();
		RequestDispatcher rd=request.getRequestDispatcher("Del.jsp");
		request.setAttribute("mylist", mylist);
		rd.forward(request, response);
	}

}
