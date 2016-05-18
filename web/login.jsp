<%-- 
    Document   : login
    Created on : May 9, 2016, 12:20:51 PM
    Author     : Farewell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>    
    <head>
        <meta charset="UTF-8">
        <title>Login Form</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <div class="login">
            <div class="login-triangle"></div>
            <h2 class="login-header">Log in</h2>
            <form class="login-container" action="LoginServlet" method="post">
                <p><input type="text" placeholder="Username" name="username"></p>
                <p><input type="password" placeholder="Password" name="password"></p>
                <p><input type="submit" value="Log in"></p>
            </form>
        </div>
        <script src='bootstrap/js/jquery.min.js'></script>
    </body>
</html>
