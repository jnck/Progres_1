<%-- 
    Document   : login
    Created on : May 9, 2016, 12:20:51 PM
    Author     : Farewell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="LoginServlet" method="post">
            Name:<input type="text" name="username"/><br>
            Password:<input type="password" name="password"/><br>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>