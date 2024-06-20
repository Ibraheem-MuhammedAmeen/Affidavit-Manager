package coms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/UpdateUsers")
public class UpdateClass extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the form data
        String uEmail = request.getParameter("email");
        String uFullname = request.getParameter("fullname");
        String uPassword = request.getParameter("password");
        String retPassword = request.getParameter("reppass");

        try {
            // Load the MySQL JDBC driver and establish a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supreme", "root", "");

            // Create the SQL query to update the user details based on their email
            String query = "UPDATE CreateUser SET uFullname=?, uPassword=? WHERE uEmail=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, uFullname);
            pst.setString(2, uPassword);
            pst.setString(3, uEmail);

            // Execute the update query
            int rowsUpdated = pst.executeUpdate();

            // Close the prepared statement and connection
            pst.close();
            con.close();

            // Check if any rows were updated
            if (rowsUpdated > 0) {
                // Redirect to a success page or display a success message
                response.sendRedirect(request.getContextPath() + "/Formtable.jsp");
            } else {
                // Redirect to an error page or display an error message
                response.sendRedirect(request.getContextPath() + "/error.html");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Redirect to an error page or display an error message
            response.sendRedirect(request.getContextPath() + "/error.html");
        }
    }
}





//package coms;
//
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import jakarta.servlet.annotation.WebServlet;
//
//
//@WebServlet("/UpdateUserss")
//public class UpdateClass extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        // Retrieve the form data
//        String uEmail = request.getParameter("email");
//        String uFullname = request.getParameter("fullname");
//        String uPassword = request.getParameter("password");
//        String retPassword = request.getParameter("reppass");
//
//        try {
//            // Load the MySQL JDBC driver and establish a connection
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supreme", "root", "");
//
//            // Create the SQL query to update the user details based on their email
//            String query = "UPDATE CreateUser SET uFullname=?, uPassword=? WHERE uEmail=?";
//            PreparedStatement pst = con.prepareStatement(query);
//            pst.setString(1, uFullname);
//            pst.setString(2, uPassword);
//            pst.setString(3, uEmail);
//
//            // Execute the update query
//            int rowsUpdated = pst.executeUpdate();
//
//            // Close the prepared statement and connection
//            pst.close();
//            con.close();
//
//            // Check if any rows were updated
//            if (rowsUpdated > 0) {
//                // Redirect to a success page or display a success message
//                response.sendRedirect(request.getContextPath() + "/Formtable.jsp");
//            } else {
//                // Redirect to an error page or display an error message
//                response.sendRedirect(request.getContextPath() + "/error.html");
//            }
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//            // Redirect to an error page or display an error message
//            response.sendRedirect(request.getContextPath() + "/error.html");
//        }
//    }
//}



