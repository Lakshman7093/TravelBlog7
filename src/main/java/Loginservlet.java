

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginservlet
 */
@WebServlet("/Loginservlet")
public class Loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	String url="jdbc:mysql://sql12.freemysqlhosting.net:3306?user=sql12715825&password=TH7I9EG9YS";
	String query="select uname from sql12715825.reg where uname=? and password=?";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     
		try 
		{
			PrintWriter out=response.getWriter();
			Class.forName("com.mysql.jdbc.Driver");
			response.setContentType("text/html");
			Connection con=DriverManager.getConnection(url);
			String n=request.getParameter("tn");
			String p=request.getParameter("tp");
			PreparedStatement ps =con.prepareStatement(query);
			ps.setString(1, n);
			ps.setString(2, p);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				//out.println("loginsucessfull");
				RequestDispatcher rd=request.getRequestDispatcher("main.html");
				rd.forward(request, response);
			}
			else
			{
				out.println("login failed");
//				RequestDispatcher rd=request.getRequestDispatcher("Login.html");
//				rd.forward(request, response);
				out.println("<a href=Login.html>TryAgian</a>");
			}
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
