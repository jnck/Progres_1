/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myServlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Farewell
 */
public class LogoutServlet extends HttpServlet {   
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        PrintWriter out=response.getWriter();
        session.removeAttribute("username");       
        out.print("You are successfully logged out!");
        request.getRequestDispatcher("login.jsp").include(request,response);
    }
}