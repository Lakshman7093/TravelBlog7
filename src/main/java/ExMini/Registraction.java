package ExMini;

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

@WebServlet("/Registraction")
public class Registraction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    String url="jdbc:mysql://localhost:3306?user=root&password=12345";
    String QUERY = "INSERT INTO datainsert (name, password) VALUES (?, ?)";

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        try (Connection cn = DriverManager.getConnection(url);
             PreparedStatement ps = cn.prepareStatement(QUERY)) {

            PrintWriter pw = resp.getWriter();
            resp.setContentType("text/html");

            String name = req.getParameter("name");
            String password = req.getParameter("password");

            ps.setString(1, name);
            ps.setString(2, password);

            int res = ps.executeUpdate();

            if (res == 0) {
                pw.println("Record not updated");
            } else {
                pw.println("Record updated");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}