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

@WebServlet("/SaveAppointmentServlet")
public class SaveAppointmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String appointmentId = request.getParameter("appointmentId");
        String customerName = request.getParameter("customerName");
        String appointmentDate = request.getParameter("appointmentDate");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avcs", "root", "");

            // Insert data into the appointment table
            String insertQuery = "INSERT INTO appointment (id, Name, Date) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, appointmentId);
            preparedStatement.setString(2, customerName);
            preparedStatement.setString(3, appointmentDate);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h1>Appointment created successfully!</h1>");
            } else {
                out.println("<h1>Failed to create appointment.</h1>");
            }

            connection.close();
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}
