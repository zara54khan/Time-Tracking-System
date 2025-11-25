package com.timetrack;

import java.io.IOException;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class ContactServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String msg = req.getParameter("message");

        try {
            Connection con = Database.getConnection();

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO contact_messages(name,email,message) VALUES(?,?,?)");

            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,msg);

            ps.executeUpdate();

            resp.sendRedirect("helpcontact.html");

        }catch (Exception e){
            resp.getWriter().println("Not Sent");
        }

    }

}
