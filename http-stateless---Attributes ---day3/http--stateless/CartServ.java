import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CartServ
 */
@WebServlet("/CartServ")
public class CartServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param  
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		String[] arr=request.getParameterValues("prod1");
		List<String> lst=new ArrayList<String>();
	
		for(int i=0;i<arr.length;i++) {
			lst.add(arr[i]);
		}		
			HttpSession session=request.getSession();
			session.setAttribute("book",lst);
			pw.print("session added"+"\n");
		pw.print(session.getAttribute("book"));
	}
}
