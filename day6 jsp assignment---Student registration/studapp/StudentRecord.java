import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;
public class StudentRecord extends HttpServlet
{
	private Connection con;
	public void init()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/psp?characterEncoding=latin1";
			con=DriverManager.getConnection(url,"root","root");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			List<Integer>mylist=new ArrayList<Integer>();
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			int age=Integer.parseInt(request.getParameter("age"));
			String address=request.getParameter("address");
			PreparedStatement pst=con.prepareStatement("insert into student values(?,?,?,?)");
			pst.setInt(1,id);
			pst.setString(2,name);
			pst.setInt(3,age);
			pst.setString(4,address);
			int k=pst.executeUpdate();
			if(k>0)
			{
				pw.println("Record has been added to the database");
			}
			else
			{
				pw.println("Cannot add");
			}
			String query = "select rollno from student";
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
			int rollno=Integer.parseInt(rs.getString("rollno"));
			mylist.add(rollno);
			}
			RequestDispatcher rd=request.getRequestDispatcher("Report.jsp");
			request.setAttribute("arrl", mylist);
			rd.forward(request,response);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
}