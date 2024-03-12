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

@WebServlet("/ProcessDeleteReceptionistsServlet")
public class ProcessDeleteReceptionistsServlet extends HttpServlet {
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
                    String sql = "DELETE FROM `receptionists registration` WHERE `User Name`=?";
                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        // Set parameter
                        statement.setString(1, username);

                        // Execute the statement
                        int rowsAffected = statement.executeUpdate();

                        if (rowsAffected > 0) {
                            out.println("<html><body><h2>Receptionists deleted successfully!</h2></body></html>");
                        } else {
                            out.println("<html><body><h2>No receptionists found with the provided username.</h2></body></html>");
                        }
                    }
                }
            } catch (Exception e) {
                out.println("<html><body><h2>Error in deleting receptionists: " + e.getMessage() + "</h2></body></html>");
            }
        }
    }
}
