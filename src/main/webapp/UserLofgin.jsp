<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
   <link rel="stylesheet" href="css/style.css">

	<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        .login-container {
            width: 300px;
            margin: 100px auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #ffffff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
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

                    </div>
                </div>
            </div>
            <div class="after-Header p-2"></div>
    </section>

	 <div class="login-container">
        <h1>Login</h1>
        <form action="logins" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" onclick="validateForm">Login</button>
        </form>
    </div>
</body>
</html>