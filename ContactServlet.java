package com.timetracking.contact;

import com.timetracking.db.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ContactServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO contacts(name,email,message) VALUES (?,?,?)");
            ps.setString(1, req.getParameter("name"));
            ps.setString(2, req.getParameter("email"));
            ps.setString(3, req.getParameter("message"));

            ps.executeUpdate();
            out.print("{\"status\":\"success\"}");

        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"status\":\"error\"}");
        }
    }
}
