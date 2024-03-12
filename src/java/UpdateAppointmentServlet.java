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

@WebServlet("/UpdateAppointmentServlet")
public class UpdateAppointmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String appointmentId = request.getParameter("appointmentId");
        String newCustomerName = request.getParameter("newCustomerName");
        String newAppointmentDate = request.getParameter("newAppointmentDate");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avcs", "root", "");

            // Update data in the appointment table
            String updateQuery = "UPDATE appointment SET Name=?, Date=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, newCustomerName);
            preparedStatement.setString(2, newAppointmentDate);
            preparedStatement.setString(3, appointmentId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h1>Appointment updated successfully!</h1>");
            } else {
                out.println("<h1>Failed to update appointment.</h1>");
            }

            connection.close();
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}
