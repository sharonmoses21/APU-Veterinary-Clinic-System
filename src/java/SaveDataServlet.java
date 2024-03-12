import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/SaveDataServlet"})
public class SaveDataServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SaveDataServlet</title>");            
            out.println("</head>");
            out.println("<body>");

            String username = request.getParameter("username");
            String[] selectedDays = request.getParameterValues("days");
            boolean checkbox = request.getParameter("checkbox") != null;

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avcs", "root", "");

                // Check if the username exists in the vets_registration table
                PreparedStatement checkUsernameStatement = connection.prepareStatement("SELECT * FROM `vets registration` WHERE `User Name` = ?");
                checkUsernameStatement.setString(1, username);
                ResultSet resultSet = checkUsernameStatement.executeQuery();

                if (resultSet.next()) {
                    // Username exists, concatenate selected days with commas
                    String concatenatedDays = String.join(",", selectedDays);

                    // Now insert data into week_working_rota table
                    PreparedStatement insertDataStatement = connection.prepareStatement("INSERT INTO week_working_rota (`User Name`, Days) VALUES (?, ?)");
                    insertDataStatement.setString(1, username);
                    insertDataStatement.setString(2, concatenatedDays);
                    insertDataStatement.executeUpdate();

                    if (checkbox) {
                        // Handle checkbox option
                    }

                    out.println("<h1>Data saved successfully!</h1>");
                } else {
                    out.println("<h1>Username not found in the vets_registration table.</h1>");
                }

                connection.close();
            } catch (Exception e) {
                out.println("<h1>Error: " + e.getMessage() + "</h1>");
            }

            out.println("</body>");
            out.println("</html>");
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
        return "Short description";
    }
}
