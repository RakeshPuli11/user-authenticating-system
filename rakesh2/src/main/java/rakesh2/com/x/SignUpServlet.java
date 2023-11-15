package rakesh2.com.x;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SignUpServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");
        String username = request.getParameter("uname");
        String pass = request.getParameter("pass1");
        String password = request.getParameter("pass2");
        if (pass.equals(password) && (!pass.equals("") || !password.equals(""))) {
            try {
                Connection con = JdbcConnection.connect();
                String query = "insert into login(username,password) values(?,?)";
                PreparedStatement psmt = con.prepareStatement(query);
                psmt.setString(1, username);
                psmt.setString(2, password);
                int rst = psmt.executeUpdate();
                if (rst > 0) {
                    pw.print("Signed up successfully");
                } else {
                    pw.print("Sign up failed.");
                }
                pw.close();
                psmt.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        else {
        	response.sendRedirect("signup.html");
        }
    }
}
