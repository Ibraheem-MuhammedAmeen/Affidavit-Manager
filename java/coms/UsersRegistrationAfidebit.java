package coms;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@MultipartConfig
@WebServlet("/addimagessss")
public class UsersRegistrationAfidebit extends HttpServlet {
    private static final long serialVersionUID = 1L;
//
    
    	protected void doPost(HttpServletRequest request, HttpServletResponse response)
    	        throws ServletException, IOException {
    		 String name = request.getParameter("name");
    	   
    	    String street = request.getParameter("street");
    	    String describe1 = request.getParameter("describe1");
    	    String describe2 = request.getParameter("describe2");
    	    String describe3 = request.getParameter("describe3");
    	    String describe4 = request.getParameter("describe4");
    	    String describe5 = request.getParameter("describe5");
    	    String describe6 = request.getParameter("describe6");
    	    String describe7 = request.getParameter("describe7");
    	    LocalDate currentDate = LocalDate.now();
    	    
    	    Part filePart = request.getPart("image");
    	    if (filePart == null || filePart.getSize() == 0) {
    	        response.getWriter().println("Please select an image.");
    	        return;
    	    }

    	    String imageFileName = filePart.getSubmittedFileName(); // get selected image file name
    	    System.out.println("Selected image file name: " + imageFileName);

    	    String uploadPath = "C:/Users/Abdulmalik/Documents/java-workspace/Supreme/images/" + imageFileName;
    	    System.out.println("Upload Path: " + uploadPath);

    	    // Your existing code...

    	    // Uploading our selected image into images folder
    	    try (FileOutputStream fos = new FileOutputStream(uploadPath);
    	            InputStream is = filePart.getInputStream()) {

    	        byte[] data = new byte[is.available()];
    	        is.read(data);
    	        fos.write(data);

    	        System.out.println("Image uploaded successfully.");
    	    } catch (IOException e) {
    	        e.printStackTrace();
    	        response.getWriter().println("Failed to upload image.");
    	        return;
    	    }

    	    // Your existing code...

    	    // Getting database connection(jdbc code)
    	    String jdbcUrl = "jdbc:mysql://localhost:3306/supreme";
    	    String username = "root";
    	    String password = "";

    	    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
    	        String query = "INSERT INTO regUsers (name, street, describe1, describe2, describe3, describe4, describe5, describe6, describe7, date, imageFileName) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    	        try (PreparedStatement stmt = connection.prepareStatement(query)) {
    	            stmt.setString(1, name);
    	            stmt.setString(2, street);
    	            stmt.setString(3, describe1);
    	            stmt.setString(4, describe2);
    	            stmt.setString(5, describe3);
    	            stmt.setString(6, describe4);
    	            stmt.setString(7, describe5);
    	            stmt.setString(8, describe6);
    	            stmt.setString(9, describe7);
    	            stmt.setDate(10, java.sql.Date.valueOf(currentDate));
    	            stmt.setString(11, imageFileName);

    	            int rows = stmt.executeUpdate();
    	            if (rows > 0) {
    	               // System.out.println("Data inserted into the database successfully.");
    	                response.sendRedirect(request.getContextPath() + "/display.html");
    	            } else {
    	                System.out.println("Failed to insert data into the database.");
    	            }			
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	        response.getWriter().println("An error occurred while processing the request.");
    	    }
    	
    	// ...

    }
//
//        String name = request.getParameter("name");
//        String street = request.getParameter("street");
//        String describe1 = request.getParameter("describe1");
//        String describe2 = request.getParameter("describe2");
//        String describe3 = request.getParameter("describe3");
//        String describe4 = request.getParameter("describe4");
//        String describe5 = request.getParameter("describe5");
//        String describe6 = request.getParameter("describe6");
//        String describe7 = request.getParameter("describe7");
//        LocalDate currentDate = LocalDate.now();
//        
//        
//        
//       
//
//        Part filePart = request.getPart("image");
//        if (file == null || file.getSize() == 0) {
//            response.getWriter().println("Please select an image.");
//            return;
//        }
//
//
//        String imageFileName = file.getSubmittedFileName(); // get selected image file name
//        System.out.println("Selected image file name: " + imageFileName);
//
//        String uploadPath = "C:/Users/Abdulmalik/Documents/java-workspace/Supreme/images/" + imageFileName;
//        System.out.println("Upload Path: " + uploadPath);
//
//       // Uploading our selected image into images folder
//        try (FileOutputStream fos = new FileOutputStream(uploadPath);
//                InputStream is = file.getInputStream()) {
//
//            byte[] data = new byte[is.available()];
//            is.read(data);
//            fos.write(data);
//
//            System.out.println("Image uploaded successfully.");
//        } catch (IOException e) {
//            e.printStackTrace();
//            response.getWriter().println("Failed to upload image.");
//            return;
//        }
//
//        // Getting database connection(jdbc code)
//        String jdbcUrl = "jdbc:mysql://localhost:3306/supreme";
//        String username = "root";
//        String password = "";
//
//        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
//            String query = "INSERT INTO regUsers (name, street, describe1, describe2, describe3, describe4, describe5, describe6, describe7, date, imageFileName) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
//            try (PreparedStatement stmt = connection.prepareStatement(query)) {
//                stmt.setString(1, name);
//                stmt.setString(2, street);
//                stmt.setString(3, describe1);
//                stmt.setString(4, describe2);
//                stmt.setString(5, describe3);
//                stmt.setString(6, describe4);
//                stmt.setString(7, describe5);
//                stmt.setString(8, describe6);
//                stmt.setString(9, describe7);
//                stmt.setDate(10, java.sql.Date.valueOf(currentDate));
//                stmt.setString(11, imageFileName);
//
//                int rows = stmt.executeUpdate();
//                if (rows > 0) {
//                   // System.out.println("Data inserted into the database successfully.");
//                    response.sendRedirect(request.getContextPath() + "/display.html");
//                } else {
//                    System.out.println("Failed to insert data into the database.");
//                }			
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.getWriter().println("An error occurred while processing the request.");
//        }
//    }
}










