

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import mypack.HibernateUtil;
import mypack.Product;

/**
 * Servlet implementation class AddServ
 */
@WebServlet("/AddServ")
public class AddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			Session session=HibernateUtil.getSessionFactory().openSession();
			Transaction transaction=session.beginTransaction();
			Product p=new Product();
			p.setpName(request.getParameter("pname"));
			p.setPrice(Integer.parseInt(request.getParameter("price").trim()));
			p.setQuantity(Integer.parseInt(request.getParameter("quantity").trim()));
			session.save(p);
			transaction.commit();
			RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");
			rd.forward(request,response);
		}
		catch(Exception e)
		{e.printStackTrace();}
	}

}
