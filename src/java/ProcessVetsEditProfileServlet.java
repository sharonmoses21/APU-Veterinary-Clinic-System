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

@WebServlet("/ProcessVetsEditProfileServlet")
public class ProcessVetsEditProfileServlet extends HttpServlet {
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
                    // Check if the username exists in the database
                    String checkUsernameQuery = "SELECT * FROM `vets registration` WHERE `User Name`=?";
                    try (PreparedStatement checkUsernameStatement = connection.prepareStatement(checkUsernameQuery)) {
                        checkUsernameStatement.setString(1, username);
                        try (ResultSet resultSet = checkUsernameStatement.executeQuery()) {
                            if (resultSet.next()) {
                                // Update the salesmen's profile
                                String updateQuery = "UPDATE `salesman registration` SET `id`=?, `Name`=?, `Password`=? WHERE `User Name`=?";
                                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                                    updateStatement.setString(1, newId);
                                    updateStatement.setString(2, newName);
                                    updateStatement.setString(3, newPassword);
                                    updateStatement.setString(4, username);

                                    // Execute the statement
                                    updateStatement.executeUpdate();

                                    out.println("<html><body><h2>Profile updated successfully!</h2></body></html>");
                                }
                            } else {
                                out.println("<html><body><h2>User not found with the provided username.</h2></body></html>");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                out.println("<html><body><h2>Error in updating profile: " + e.getMessage() + "</h2></body></html>");
            }
        }
    }
}

