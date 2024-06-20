<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
     <link rel="stylesheet" href="css/bootstrap.css">
     
   <link rel="stylesheet" href="css/bootstrap.css">
   <link rel="stylesheet" href="css/style.css">
    <style type="text/css">
    	.center-container {
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    height: 100%;
		}
    
    
    </style>
    
    <style>
    body {
        font-family: Arial, sans-serif;
    }
    table {
        border-collapse: collapse;
        width: 100%;
    }
    th, td {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
    th {
        background-color: #f2f2f2;
    }
    tr:nth-child(even) {
        background-color: #f2f2f2;
    }
    tr:hover {
        background-color: #ddd;
    }
    button {
        padding: 5px 10px;
        background-color: #007bff;
        border: none;
        color: white;
        cursor: pointer;
    }
    button:hover {
        background-color: #0056b3;
    }
    .button-form {
        display: inline-block;
        margin-right: 10px;
    }
</style>
</head>
<body>


		 <section class="row">
        <div class="col-md-12">

            <div class="header-color p-4">
                <div class="row">
                    <div class="col-md-3">

                    </div>
                    <div class="col-md-6 text-center text-white">
                        <h5>HIGHT COURT OF JUSTICE</h5>
                        <p>FEDERAL CAPITAL TERRITORY, ABUJA</p>
                    </div>
                    <div class="col-md-3">
						<button class="btn btn-success">
            					<a href="index.jsp" class="text-white  text-decoration-none">LogOut</a>
        				</button>
        				
        				<button class="btn btn-success">
            					<a href="UserLofgin.jsp" class="text-white  text-decoration-none">Login As User</a>
        				</button>
        			
        				<button class="btn btn-success">
            					<a href="CreateUsers.html" class="text-white  text-decoration-none">Register</a>
        				</button>
                    </div>
                </div>
            </div>
            <div class="after-Header p-2"></div>
    </section>
		
	
	
	
	<br>
	
	
	
	<%
    String status = (String) request.getAttribute("status");
    if (status != null) {
        if (status.equals("success")) {
            out.println("<p>User details updated successfully!</p>");
        } else if (status.equals("failed")) {
            out.println("<p>Failed to update user details.</p>");
        }
    }
    
    
	%>
	
	<h3 class="center-container ">PASSWORD REGISTRANTS.</h3>
    <center>
    <table border="1">
        <!-- Table headers -->
        <tr>
            <th>id</th>
            <th>username</th>
            <th>Email</th>
            <th>password</th>
            <th>Repeatpassword</th>
            <th>Actions</th>
        </tr>
        <% 
        try {
            // Load the MySQL JDBC driver and establish a connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supreme", "root", "");
            Statement st = con.createStatement();

            // Execute the SQL query to retrieve data from the "CreateUser" table
            String query = "SELECT * FROM CreateUser";
            ResultSet rs = st.executeQuery(query);

            // Iterate over the result set and display the data in table rows
            while (rs.next()) {
                %>
                <tr>
                    <td><%= rs.getInt("id") %></td>
                    <td><%= rs.getString("uFullname") %></td>
                    <td><%= rs.getString("uEmail") %></td>
                    <td><%= rs.getString("uPassword") %></td>
                    <td><%= rs.getString("RetPassword") %></td>
                    <td>
                        <!-- Update form -->
                        <form class="button-form" action="Update.html" method="post">
                            <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                            <button class="btn btn-primary" type="submit">Update</button>
                        </form>
                        <!-- Delete form -->
                        <form class="button-form" action="delete" method="post">
                            <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                            <button class="btn btn-danger" type="submit" onclick="return confirm('Are you sure you want to delete this row?')">Delete</button>
                        </form>
                    </td>
                </tr>
                <%
            }

            // Close the result set, statement, and connection
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
    </table>
</center>
    
    
    
    <br>
     <br>
      <br>
       <br>
    				<h3 class="center-container ">AFIDAVIT REGISTRANTS.</h3>
    
     <center>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Street</th>
                <th>Date</th>
               
                <th>Actions</th>
            </tr>
            <% 
            try {
                // Load the MySQL JDBC driver and establish a connection
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/supreme", "root", "");
                Statement st = con.createStatement();

                // Execute the SQL query to retrieve data from the "regUsers" table
                String query = "SELECT * FROM regUsers";
                ResultSet rs = st.executeQuery(query);

                // Iterate over the result set and display the data in table rows
                while (rs.next()) {
            %>
            <tr>
                <td><%= rs.getInt("id") %></td>
                <td><%= rs.getString("name") %></td>
                <td><%= rs.getString("street") %></td>
                <td><%= rs.getDate("date") %></td>
               
                <td>
                    <form class="button-form" action="UpdateUserTesting.jsp" method="post">
                        <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                        <button type="submit" class="btn btn-primary "  style="margin-top: 10px;">Update</button>
                    </form>
                    <form class="button-form" action="DeleteUserServletssss" method="post" onsubmit="return confirm('Are you sure you want to delete this user?')">
                        <input type="hidden" name="id" value="<%= rs.getInt("id") %>">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>
                </td>
            </tr>
            <% 
                }

                // Close the result set, statement, and connection
                rs.close();
                st.close();
                con.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
            %>
        </table>
    </center>
</body>
</html>
