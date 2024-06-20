package coms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;


@WebServlet("/logins")
public class Logins extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the form data
        String uEmail = request.getParameter("email");
        String uPassword = request.getParameter("password");

        try {
            // Load the MySQL JDBC driver and establish a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supreme", "root", "");
            PreparedStatement pst = con.prepareStatement("select * from CreateUser where uEmail = ? and uPassword =?");

           
            pst.setString(1, uEmail);
            pst.setString(2, uPassword);

            // Execute the query and get the result set
            ResultSet rs = pst.executeQuery();

            // Check if the email and password combination exists in the database
            if (rs.next()) {
                // Successful login, redirect to a success page or do any further processing
                response.sendRedirect(request.getContextPath() + "/formUserRegister.html");
            } else {
                // Invalid login, redirect to an error page or show an error message
                response.sendRedirect(request.getContextPath() + "/UserLofgin.jsp");
            	 //request.setAttribute("status", "failed");
            }

            // Close the result set, prepared statement, and connection
            rs.close();
            pst.close();
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Redirect to an error page or display an error message
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

}
