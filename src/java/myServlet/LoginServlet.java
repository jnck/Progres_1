/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Farewell
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ehealth", "root", "");
            PreparedStatement pst = conn.prepareStatement("Select username,password from master_dokter where username=? and password=?");
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                session.setAttribute("username", username);
                response.sendRedirect("index.jsp");
            } 
            else {
                out.print("Incorrect login credentials");
                request.getRequestDispatcher("login.jsp").include(request,response);
            }
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
//        if(password.equals("katasandi12")){          
//            Cookie ck=new Cookie("name",name);
//            response.addCookie(ck);
//            request.getRequestDispatcher("index.jsp").include(request,response); 
//        }        
//        else{
//            out.print("Wrong Password!");
//            request.getRequestDispatcher("login.jsp").include(request,response);
//        }