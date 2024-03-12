/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ProcessManagerLoginServlet")
public class ProcessManagerLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Retrieve form parameters
            String username = request.getParameter("username");
            String password = request.getParameter("password");

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
                    String sql = "SELECT * FROM manager WHERE `User Name` = ? AND `Password` = ?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        // Set parameters
                        statement.setString(1, username);
                        statement.setString(2, password);

                        // Execute the statement
                        ResultSet resultSet = statement.executeQuery();

                        // Check if the result set has any rows
                        if (resultSet.next()) {
                            // Valid login, set up a session
                            HttpSession session = request.getSession();
                            session.setAttribute("username", username);

                            // Redirect to Manager Dashboard (you need to create this page)
                            response.sendRedirect("managerDashboard.jsp");
                        } else {
                            // Invalid login
                            out.println("Incorrect username or password.");
                        }
                    }
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            }
        }
    }
}
