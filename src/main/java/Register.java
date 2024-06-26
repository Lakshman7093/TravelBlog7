

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	 String url="jdbc:mysql://sql12.freemysqlhosting.net:3306?user=sql12715825&password=TH7I9EG9YS";
     
     String query="insert into sql12715825.reg values(?,?)";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			Connection cn =DriverManager.getConnection(url);
			PreparedStatement ps =cn.prepareStatement(query);
			String name=request.getParameter("name");
			String pass=request.getParameter("pass");
			ps.setString(1, name);
			ps.setString(2, pass);
		  int res=ps.executeUpdate();
		  if(res>0)
		  {
			  pw.println("Registration Successful");
			  pw.println("<a href=Login.html>LoginHere</a>");
			  
		  }
		  else
		  {
			  pw.println("<font color=red size=15>Login Failed!!<br>");
			  pw.println("<a href=index.html>TryAgian</a>");
		  }
			
			
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
