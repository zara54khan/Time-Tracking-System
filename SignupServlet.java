package com.timetrack;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        try {
            Connection con = Database.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO users(name,email,password) VALUES(?,?,?)");

            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,pass);

            ps.executeUpdate();

            resp.sendRedirect("logintime.html");

        } catch (Exception e) {
            resp.getWriter().println("Signup Failed");
        }
    }
}
