package BLL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="welcomeServlet", urlPatterns="/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String n = request.getParameter("username");
        out.print("<head>\n" +
                "<style>\n" +
                "#customers {\n" +
                "    font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
                "    border-collapse: collapse;\n" +
                "    width: 100%;\n" +
                "}\n" +
                "\n" +
                "#customers td, #customers th {\n" +
                "    border: 1px solid #ddd;\n" +
                "    padding: 8px;\n" +
                "}\n" +
                "\n" +
                "#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
                "\n" +
                "#customers tr:hover {background-color: #ddd;}\n" +
                "\n" +
                "#customers th {\n" +
                "    padding-top: 12px;\n" +
                "    padding-bottom: 12px;\n" +
                "    text-align: left;\n" +
                "    background-color: #4CAF50;\n" +
                "    color: white;\n" +
                "}\n" +
                "</style>\n" +
                "</head>");
        out.print("<h3>Welcome " + n + "</h3>");
        out.print("<table id=\"customers\">\n" +
                "  <tr>\n" +
                "    <th>Id</th>\n" +
                "    <th>Airplane type</th>\n" +
                "    <th>Departure city</th>\n" +
                "    <th>Departure date</th>\n" +
                "    <th>Arrival city</th>\n" +
                "    <th>Arrival date</th>\n" +
                "  </tr>\n"+
                "</table>");


        out.close();
    }
}