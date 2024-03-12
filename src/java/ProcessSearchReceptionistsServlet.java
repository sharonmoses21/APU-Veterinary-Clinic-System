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

@WebServlet("/ProcessSearchReceptionistsServlet")
public class ProcessSearchReceptionistsServlet extends HttpServlet {
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
                    String sql = "SELECT * FROM `receptionists registration` WHERE `User Name`=?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        // Set parameter
                        statement.setString(1, username);

                        // Execute the statement
                        try (ResultSet resultSet = statement.executeQuery()) {
                            if (resultSet.next()) {
                                // Display customer details
                                out.println("<html><body><h2>Receptionists Details:</h2>");
                                out.println("<p>ID: " + resultSet.getString("id") + "</p>");
                                out.println("<p>Name: " + resultSet.getString("Name") + "</p>");
                                out.println("<p>User Name: " + resultSet.getString("User Name") + "</p>");
                                out.println("<p>Password: " + resultSet.getString("Password") + "</p>");
                                out.println("<p>Status: " + resultSet.getString("Status") + "</p>");
                                out.println("</body></html>");
                            } else {
                                out.println("<html><body><h2>No receptionist found with the provided username.</h2></body></html>");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                out.println("<html><body><h2>Error in searching for Receptionists: " + e.getMessage() + "</h2></body></html>");
            }
        }
    }
}
