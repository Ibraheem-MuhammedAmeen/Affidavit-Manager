package coms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@WebServlet("/SupremeCreateUser")
public class SupremeCreateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con = null;
		RequestDispatcher dispatcher = null;
		
		String uFullname = request.getParameter("fullname");
		String uEmail = request.getParameter("email");
		String uPassword = request.getParameter("password");
		String uRetPassword  = request.getParameter("Repeat");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supreme", "root", "");
			PreparedStatement pst = con.prepareStatement("insert into CreateUser(uFullname,uEmail,uPassword,RetPassword) values(?,?,?,?) ");
			pst.setString(1, uFullname);
    		pst.setString(2, uEmail);
			pst.setString(3, uPassword);
			pst.setString(4, uRetPassword);
			
			int rowcount = pst.executeUpdate();
			//dispatcher = request.getRequestDispatcher("success.html");
			if(rowcount > 0) {
              request.setAttribute("status", "success");
              response.sendRedirect(request.getContextPath() + "/Formtable.jsp");
			}else {
				 request.setAttribute("status", "failed");
			}
			dispatcher.forward(request,response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}





