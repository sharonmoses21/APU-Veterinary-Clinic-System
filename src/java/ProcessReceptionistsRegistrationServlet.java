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

@WebServlet("/ProcessReceptionistsRegistrationServlet")
public class ProcessReceptionistsRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Retrieve form parameters
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            // JDBC URL, username, and password of MySQL server
            String jdbcUrl = "jdbc:mysql://localhost:3306/avcs";
            String dbUser = "root";
            String dbPassword = "";

            try {
                // Load the JDBC driver
                Class.forName("com.mysql.jdbc.Driver");

                // Establish a connection
                try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                    // Create a SQL statement
                    String sql = "INSERT INTO `receptionists registration` (`id`, `Name`, `User Name`, `Password`) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        // Set parameters
                        statement.setString(1, id);
                        statement.setString(2, name);
                        statement.setString(3, username);
                        statement.setString(4, password);

                        // Execute the statement
                        statement.executeUpdate();

                        out.println("Registration successful!");
                    }
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        }
    }
}

