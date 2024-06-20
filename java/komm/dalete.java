package komm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

/**
 * Servlet implementation class dalete
 */
@WebServlet("delete")
public class dalete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the ID parameter from the form
        int id = Integer.parseInt(request.getParameter("id"));

        try {
            // Load the MySQL JDBC driver and establish a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supreme", "root", "");
            Statement st = con.createStatement();

            // Execute the SQL query to delete the row with the given ID
            String query = "DELETE FROM CreateUser WHERE id = " + id;
            st.executeUpdate(query);

            // Close the statement and connection
            st.close();
            con.close();

            // Redirect back to the original page
            response.sendRedirect(request.getContextPath() + "/Formtable.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
