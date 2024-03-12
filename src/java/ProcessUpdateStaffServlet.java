/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProcessUpdateStaffServlet")
public class ProcessUpdateStaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Retrieve form parameters
            String username = request.getParameter("username");
            String newId = request.getParameter("newId");
            String newName = request.getParameter("newName");
            String newPassword = request.getParameter("newPassword");

            // JDBC URL, username, and password of MySQL server
            String jdbcUrl = "jdbc:mysql://localhost:3306/avcs";
            String dbUser = "root";
            String dbPassword = "";

            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish a connection
                try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                    // Create a SQL statement
                    String sql = "UPDATE manager SET id=?, Name=?, Password=? WHERE `User Name`=?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        // Set parameters
                        statement.setString(1, newId);
                        statement.setString(2, newName);
                        statement.setString(3, newPassword);
                        statement.setString(4, username);

                        // Execute the statement
                        int rowsAffected = statement.executeUpdate();

                        if (rowsAffected > 0) {
                            out.println("<html><body><h2>Staff updated successfully!</h2></body></html>");
                        } else {
                            out.println("<html><body><h2>No staff found with the provided username.</h2></body></html>");
                        }
                    }
                }
            } catch (Exception e) {
                out.println("<html><body><h2>Error in updating staff: " + e.getMessage() + "</h2></body></html>");
            }
        }
    }
}
