/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProcessVetsRegistrationServlet", urlPatterns = {"/ProcessVetsRegistrationServlet"})
public class ProcessVetsRegistrationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            // Retrieve form data
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ProcessVetsRegistrationServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            // JDBC database URL, username, and password of MySQL server (using PHPMyAdmin)
            String url = "jdbc:mysql://localhost:3306/avcs";
            String dbUser = "root";
            String dbPassword = "";

            // JDBC variables for opening, closing and managing connection
            try (Connection connection = DriverManager.getConnection(url, dbUser, dbPassword)) {

                // Prepared statement to insert data into the database
                String query = "INSERT INTO `vets registration` (`id`, `Name`, `User Name`, `Password`) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pst = connection.prepareStatement(query)) {
                    pst.setString(1, id);
                    pst.setString(2, name);
                    pst.setString(3, username);
                    pst.setString(4, password);

                    // Execute the prepared statement
                    pst.executeUpdate();

                    out.println("<html><body><h2>Registration successful!</h2></body></html>");
                }

            } catch (SQLException e) {
                out.println("<html><body><h2>Error in registration: " + e.getMessage() + "</h2></body></html>");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Process Vets Registration Servlet";
    }
}


