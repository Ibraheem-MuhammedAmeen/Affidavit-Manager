<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="css/bootstrap.css">
  <link rel="stylesheet" href="css/style.css">
  <title>Login</title>
  <style>
    body {
      font-family: Arial, sans-serif;
    }

    h1 {
      color: #007BFF;
    }

    form {
      margin-top: 20px;
      width: 300px;
      border: 1px solid #ccc;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
      /* Center the form horizontally */
      margin: 0 auto;
    }

    label,
    input[type="email"],
    input[type="password"],
    input[type="submit"] {
      display: block;
      margin-bottom: 10px;
      width: 100%;
      box-sizing: border-box;
    }

    input[type="submit"] {
      background-color: #007BFF;
      color: #fff;
      border: none;
      padding: 10px 15px;
      cursor: pointer;
      border-radius: 5px;
    }

    input[type="submit"]:hover {
      background-color: #0056b3;
    }

    .center-container {
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100%;
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
            <h5>HIGH COURT OF JUSTICE</h5>
            <p>FEDERAL CAPITAL TERRITORY, ABUJA</p>
          </div>
          <div class="col-md-3">

          </div>
        </div>
      </div>
      <div class="after-Header p-2"></div>
    </div>
  </section>

  <h1 class="center-container">Admin Login</h1>
  <div class="center-container">
    <form action="loginProcess.jsp" method="post">
      <label for="email">Email:</label>
      <input type="email" id="email" name="email" required>
      <br>
      <label for="password">Password:</label>
      <input type="password" id="password" name="password" required>
      <br>
      <input type="submit" value="Login">
    </form>
  </div>
</body>
</html>
