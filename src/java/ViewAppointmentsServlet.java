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

@WebServlet("/ViewAppointmentsServlet")
public class ViewAppointmentsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String vetUsername = request.getParameter("vetUsername");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avcs", "root", "");

            // Retrieve appointments associated with the vet from the appointment table
            String viewQuery = "SELECT * FROM appointment WHERE vet=?";
            PreparedStatement preparedStatement = connection.prepareStatement(viewQuery);
            preparedStatement.setString(1, vetUsername);

            ResultSet resultSet = preparedStatement.executeQuery();

            out.println("<h1>Appointments for Vet: " + vetUsername + "</h1>");
out.println("<table>");
out.println("<tr><th>ID</th><th>Name</th><th>Date</th></tr>");

while (resultSet.next()) {
    out.println("<tr>");
    out.println("<td>" + resultSet.getString("id") + "</td>");
    out.println("<td>" + resultSet.getString("Name") + "</td>");
    out.println("<td>" + resultSet.getString("Date") + "</td>");
    out.println("</tr>");
}

out.println("</table>");

            connection.close();
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}
