package rakesh2.com.x;
import java.sql.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LogServlet")
public class LogServlet extends HttpServlet {
	
	public LogServlet() {
	        super();
	    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
//		System.out.println(username);
//		System.out.println(password);
		
		try {
			Connection con=JdbcConnection.connect();
	        String query = "select * from login where username = (?) and password = (?)";
	        PreparedStatement psmt = con.prepareStatement(query);
	        psmt.setString(1, username);
	        psmt.setString(2, password);
	        ResultSet rst = psmt.executeQuery();
		    if (rst.next()) {
		    	response.sendRedirect("home.html"); } 
		    else {
	                pw.print("Login failed.");}
	        pw.close();
	        psmt.close();
	        con.close();
	    	}
	    	catch (SQLException ex) { 
	            System.out.println("SQLException: " + ex.getMessage());
	            System.out.println("SQLState: " + ex.getSQLState());
	            System.out.println("VendorError: " + ex.getErrorCode());
	        } 
		    catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
	} 
}
