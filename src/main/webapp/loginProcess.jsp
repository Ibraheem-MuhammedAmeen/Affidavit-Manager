<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.net.URLEncoder" %>


<%
    // Retrieve the entered email and password from the form
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    // Check if the email and password match the specified values
    if ("ibrakd234@gmail.com".equals(email) && "123456789".equals(password)) {
        // Login successful, redirect to success.jsp
        String encodedEmail = URLEncoder.encode(email, "UTF-8");
        response.sendRedirect("Formtable.jsp?email=" + encodedEmail);
    } else{
    	 response.sendRedirect("index.jsp" );
    }
%>
