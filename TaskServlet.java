package com.timetracking.task;

import com.timetracking.db.DBConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class TaskServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("application/json");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession(false);
        if (session == null) return;

        String email = (String) session.getAttribute("userEmail");

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM tasks WHERE user_email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            StringBuilder json = new StringBuilder("[");
            while (rs.next()) {
                json.append("{")
                    .append("\"id\":").append(rs.getInt("id")).append(",")
                    .append("\"task\":\"").append(rs.getString("task")).append("\",")
                    .append("\"completed\":").append(rs.getBoolean("completed"))
                    .append("},");
            }

            if (json.length() > 1) json.deleteCharAt(json.length() - 1);
            json.append("]");

            out.print(json.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        HttpSession session = req.getSession(false);
        String email = (String) session.getAttribute("userEmail");
        String task = req.getParameter("task");

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO tasks(user_email,task) VALUES (?,?)");
            ps.setString(1, email);
            ps.setString(2, task);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(
                "UPDATE tasks SET completed = NOT completed WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        int id = Integer.parseInt(req.getParameter("id"));

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps =
                con.prepareStatement("DELETE FROM tasks WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
