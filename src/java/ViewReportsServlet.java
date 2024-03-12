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

@WebServlet("/ViewReportsServlet")
public class ViewReportsServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/avcs", "root", "");

            // Retrieve and display reports for the given username from the week_working_rota table
            String viewQuery = "SELECT * FROM week_working_rota WHERE `User Name`=?";
            PreparedStatement preparedStatement = connection.prepareStatement(viewQuery);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            out.println("<h1>Reports for User: " + username + "</h1>");
            out.println("<table>");
            out.println("<tr><th>User Name</th><th>Days</th></tr>");

            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString("User Name") + "</td>");
                out.println("<td>" + resultSet.getString("Days") + "</td>");
                out.println("</tr>");
            }

            out.println("</table>");

            connection.close();
        } catch (Exception e) {
            out.println("<h1>Error: " + e.getMessage() + "</h1>");
        }
    }
}
