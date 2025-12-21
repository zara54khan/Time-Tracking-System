package com.timetracking.auth;

import com.timetracking.db.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class SignupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement check =
                con.prepareStatement("SELECT id FROM users WHERE email=?");
            check.setString(1, email);
            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                out.print("{\"status\":\"exists\"}");
                return;
            }

            PreparedStatement insert =
                con.prepareStatement("INSERT INTO users(email,password) VALUES (?,?)");
            insert.setString(1, email);
            insert.setString(2, password);
            insert.executeUpdate();

            out.print("{\"status\":\"success\"}");

        } catch (Exception e) {
            e.printStackTrace();
            out.print("{\"status\":\"error\"}");
        }
    }
}
