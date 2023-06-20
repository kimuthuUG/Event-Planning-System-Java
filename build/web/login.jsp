<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Login | Event Planning System</title>
  <link rel="stylesheet" type="text/css" href="css/login.css">
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
  
  <style>
      body{
          background-image: url('images/image_3.jpg');
          background-repeat: no-repeat;
          background-size: cover;
      }
  </style>
</head>
<body>
    
<div class="bgoverlay"></div>
<div class="container">
  <div class="form sign-in-container">
    <form action="<%=request.getContextPath()%>/login" method="post">
      <h1>Sign in</h1>
      <input type="text" name="email" placeholder="User Email">
      <input type="password" name="password" placeholder="Password">
      <button type="submit">Sign In</button>
    </form>
  </div>
</div>
</body>
</html>
