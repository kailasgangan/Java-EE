

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class servlet1 extends HttpServlet {
	private Connection conn;
	public void init() {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/mydb";
			conn=DriverManager.getConnection(url,"root","root");
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

                  List<String> lst=new ArrayList<String>();
		try{
		PreparedStatement pst=conn.prepareStatement("select loc from dept");
		ResultSet rs=pst.executeQuery();
		ResultSetMetaData m=rs.getMetaData();
                     while(rs.next()){
                     String s=rs.getString(1);
                     lst.add(s);
                     }

		}	
		catch(Exception ee)
			{
				System.out.println(ee);
			}
 request.setAttribute("loc",lst);
			RequestDispatcher rd=request.getRequestDispatcher("servlet2");
			rd.forward(request,response);

	}

}
