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

@WebServlet("/SaveDiagnosisServlet")
public class SaveDiagnosisServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String petId = request.getParameter("petId");
        String diagnosis = request.getParameter("diagnosis");
        String prognosis = request.getParameter("prognosis");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avcs", "root", "");

            // Update data in the pet table
            String updateQuery = "UPDATE pet SET diagnosis=?, prognosis=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, diagnosis);
            preparedStatement.setString(2, prognosis);
            preparedStatement.setString(3, petId);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                out.println("<h1>Diagnosis and prognosis saved successfully!</h1>");
            } else {
                out.println("<h1>Failed to save diagnosis and prognosis.</h1>");
            }

            connection.close();
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}
