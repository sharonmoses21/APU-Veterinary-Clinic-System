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

@WebServlet("/AssignAppointmentServlet")
public class AssignAppointmentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String appointmentId = request.getParameter("appointmentId");
        String vetUsername = request.getParameter("vetUsername");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avcs", "root", "");

            // Check if the vet exists in the vets_registration table
            PreparedStatement checkVetStatement = connection.prepareStatement("SELECT * FROM `vets registration` WHERE `User Name` = ?");
            checkVetStatement.setString(1, vetUsername);
            if (checkVetStatement.executeQuery().next()) {
                // Vet exists, now update the appointment table with vet information
                String updateQuery = "UPDATE appointment SET vet=? WHERE id=?";
                PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, vetUsername);
                preparedStatement.setString(2, appointmentId);

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    out.println("<h1>Appointment assigned to vet successfully!</h1>");
                } else {
                    out.println("<h1>Failed to assign appointment to vet.</h1>");
                }
            } else {
                out.println("<h1>Vet not found in the vets_registration table.</h1>");
            }

            connection.close();
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}
