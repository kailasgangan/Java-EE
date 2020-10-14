package mypack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddServ
 */
@WebServlet("/AddServ")
public class AddServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public StudentDAO sdao;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Student s=new Student();
		s.setName(request.getParameter("name"));
		s.setAddress(request.getParameter("address"));
		String var=request.getParameter("persistance");
		if(var.equalsIgnoreCase("File"))
		{
			s.setRollNo(50);
			StudentDAOFileImpl sdaofile=new StudentDAOFileImpl();
			sdaofile.addStudent(s);
			PrintWriter pw=response.getWriter();
			pw.println("Your data has been persisted in the File SUCCESSFULLY!!");
		}
		else 
		{
			StudentDAODataImpl sdaodata=new StudentDAODataImpl();
			sdaodata.addStudent(s);
			PrintWriter pw=response.getWriter();
			pw.println("Your data has been persisted in the Database SUCCESSFULLY!!");
		}
	}

}
