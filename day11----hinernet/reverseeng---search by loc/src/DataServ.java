

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

import mypack.Dept;
import mypack.HibernateUtil;

/**
 * Servlet implementation class DataServ
 */
@WebServlet("/DataServ")
public class DataServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	  Session session=HibernateUtil.getSessionFactory().openSession();
	  String location=request.getParameter("loc");
	  Query<?> query=session.createQuery("from Dept where Location=:val");
	  query.setParameter("val", location);
	  List<Dept> mylist=(List<Dept>)query.list();
	  RequestDispatcher rd=request.getRequestDispatcher("Data.jsp");
	  request.setAttribute("mylist", mylist);
	  rd.forward(request, response);
	}

}
