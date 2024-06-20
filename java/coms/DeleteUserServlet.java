

package coms;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteUserServletssss")
public class DeleteUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));

        String jdbcUrl = "jdbc:mysql://localhost:3306/supreme";
        String username = "root";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "DELETE FROM regUsers WHERE id=?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, userId);
                int rowsDeleted = stmt.executeUpdate();
                if (rowsDeleted > 0) {
                    response.sendRedirect(request.getContextPath() + "/Formtable.jsp");
                } else {
                    response.getWriter().println("Failed to delete user.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred while processing the request.");
        }
    }
}
