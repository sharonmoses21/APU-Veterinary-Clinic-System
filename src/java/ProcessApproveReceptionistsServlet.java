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

@WebServlet("/ProcessApproveReceptionistsServlet")
public class ProcessApproveReceptionistsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Retrieve form parameter
            String username = request.getParameter("username");

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
                    String sql = "UPDATE `receptionists registration` SET Status='Approved' WHERE `User Name`=?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        // Set parameter
                        statement.setString(1, username);

                        // Execute the statement
                        int rowsAffected = statement.executeUpdate();

                        if (rowsAffected > 0) {
                            out.println("<html><body><h2>Receptionist approved successfully!</h2></body></html>");
                        } else {
                            out.println("<html><body><h2>No Receptionist found with the provided username.</h2></body></html>");
                        }
                    }
                }
            } catch (Exception e) {
                out.println("<html><body><h2>Error in approving Receptionist: " + e.getMessage() + "</h2></body></html>");
            }
        }
    }
}
