package com.timetrack;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        try{
            Connection con = Database.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM users WHERE email=? AND password=?");

            ps.setString(1,email);
            ps.setString(2,pass);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                resp.sendRedirect("index.html");
            }else{
                resp.getWriter().println("Invalid Login");
            }

        }catch (Exception e){
            resp.getWriter().println("Login Failed");
        }
    }
}
