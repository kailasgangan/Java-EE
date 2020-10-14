import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class RegisterServ extends HttpServlet
{
	private Connection con;
	public void init()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mydb";
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
			String name=request.getParameter("name");
                        String address=request.getParameter("address");
                        String email=request.getParameter("email");
                        String loginid=request.getParameter("loginid");
                         String password=request.getParameter("password");
			PreparedStatement pst=con.prepareStatement("insert into register values(?,?,?,?,?)");
			pst.setString(1,name);
                        pst.setString(2,address);
			pst.setString(3,email);
                        pst.setString(4,loginid); 
                        pst.setString(5,password);
			int k=pst.executeUpdate();

			if(k>0)
			{
				pw.println("Record has been added");
			}
			else
			{
				pw.println("cannot add");
			}
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}
}