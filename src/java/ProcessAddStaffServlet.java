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

@WebServlet("/ProcessAddStaffServlet")
public class ProcessAddStaffServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // Retrieve form parameters
            String id = request.getParameter("id");
            String username = request.getParameter("username");
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            // JDBC URL, username, and password of MySQL server
            String jdbcUrl = "jdbc:mysql://localhost:3306/carsalessystem";
            String dbUser = "root";
            String dbPassword = "";

            try {
                // Load the JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish a connection
                try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                    // Create a SQL statement
                    String sql = "INSERT INTO manager (id, `User Name`, Name, Password) VALUES (?, ?, ?, ?)";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        // Set parameters
                        statement.setString(1, id);
                        statement.setString(2, username);
                        statement.setString(3, name);
                        statement.setString(4, password);

                        // Execute the statement
                        statement.executeUpdate();

                        out.println("<html><body><h2>Staff added successfully!</h2></body></html>");
                    }
                }
            } catch (Exception e) {
                out.println("<html><body><h2>Error in adding staff: " + e.getMessage() + "</h2></body></html>");
            }
        }
    }
}
