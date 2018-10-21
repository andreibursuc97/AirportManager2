package BLL;

import dao.CityDao;
import dao.FlightDao;
import model.FlightEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name="welcomeServlet", urlPatterns="/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        FlightDao flightDao = new FlightDao();
        Cookie[] cookies = request.getCookies();
        String n="";
        for (Cookie cookie : cookies) {

            if ("Adminlogged".equals(cookie.getName())) {
                n=cookie.getValue();
            }
        }
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
                "<style>\n" +
                "input[type=text], select {\n" +
                "    width: 100%;\n" +
                "    padding: 12px 20px;\n" +
                "    margin: 8px 0;\n" +
                "    display: inline-block;\n" +
                "    border: 1px solid #ccc;\n" +
                "    border-radius: 4px;\n" +
                "    box-sizing: border-box;\n" +
                "}\n" +
                "\n" +
                "input[type=submit] {\n" +
                "    width: 15%;\n" +
                "    background-color: #4CAF50;\n" +
                "    color: white;\n" +
                "    padding: 14px 20px;\n" +
                "    margin: 8px 0;\n" +
                "    border: none;\n" +
                "    border-radius: 4px;\n" +
                "    cursor: pointer;\n" +
                "}" +
                "\n" +
                "input[type=submit]:hover {\n" +
                "    background-color: #45a049;\n" +
                "}\n" +
                "\n" +
                "div {\n" +
                "    border-radius: 5px;\n" +
                "    background-color: #f2f2f2;\n" +
                "    padding: 20px;\n" +
                "}\n" +
                "</style>" +
                "</head>");
        out.print("<h3>Welcome " + n + "</h3>");
        out.print(
                        "  <form action=\"LogOutServlet\" method=\"POST\">\n" +
                        "    <input type=\"submit\" value=\"Log Out\">\n" +
                        "  </form>\n");
        out.print("<table id=\"customers\">\n" +
                "  <tr>\n" +
                "    <th>Id</th>\n" +
                "    <th>Airplane type</th>\n" +
                "    <th>Departure city</th>\n" +
                "    <th>Departure date</th>\n" +
                "    <th>Arrival city</th>\n" +
                "    <th>Arrival date</th>\n" +
                "  </tr>\n");
        List<FlightEntity> flightEntities = flightDao.getAllFlights();
        CityDao cityDao = new CityDao();
        for(FlightEntity flightEntity:flightEntities)
        {
            out.print("<tr>\n" +
                    "    <td>"+ flightEntity.getId() +"</td>\n" +
                    "    <td>"+ flightEntity.getAirplaneType() +"</td>\n" +
                    "    <td>"+ cityDao.getCityById(flightEntity.getDepartureCityId()).getCityName() +"</td>\n" +
                    "    <td>"+ flightEntity.getDepartureDate() +"</td>\n" +
                    "    <td>"+ cityDao.getCityById(flightEntity.getArrivalCityId()).getCityName() +"</td>\n" +
                    "    <td>"+ flightEntity.getArrivalDate() +"</td>\n" +
                    "  </tr>");
        }

        out.print("</table>");

        out.print("<h3>Using CSS to style an HTML Form</h3>\n" +
                "\n" +
                "<div style='float:left'>\n" +
                "  <form action=\"/action_page.php\">\n" +
                "    <label for=\"fname\">First Name</label>\n" +
                "    <input type=\"text\" id=\"fname\" name=\"firstname\" placeholder=\"Your name..\">\n" +
                "\n" +
                "    <label for=\"lname\">Last Name</label>\n" +
                "    <input type=\"text\" id=\"lname\" name=\"lastname\" placeholder=\"Your last name..\">\n" +
                "\n" +
                "    <label for=\"country\">Country</label>\n" +
                "    <select id=\"country\" name=\"country\">\n" +
                "      <option value=\"australia\">Australia</option>\n" +
                "      <option value=\"canada\">Canada</option>\n" +
                "      <option value=\"usa\">USA</option>\n" +
                "    </select>\n" +
                "  \n" +
                "    <input type=\"submit\" value=\"Submit\">\n" +
                "  </form>\n" +
                "</div>");

        out.print(
                "<div style='float:left'>\n" +
                "<h3>Using CSS to style an HTML Form</h3>\n" +
                "\n" +
                "  <form action=\"/action_page.php\">\n" +
                "    <label for=\"fname\">First Name</label>\n" +
                "    <input type=\"text\" id=\"fname\" name=\"firstname\" placeholder=\"Your name..\">\n" +
                "\n" +
                "    <label for=\"lname\">Last Name</label>\n" +
                "    <input type=\"text\" id=\"lname\" name=\"lastname\" placeholder=\"Your last name..\">\n" +
                "\n" +
                "    <label for=\"country\">Country</label>\n" +
                "    <select id=\"country\" name=\"country\">\n" +
                "      <option value=\"australia\">Australia</option>\n" +
                "      <option value=\"canada\">Canada</option>\n" +
                "      <option value=\"usa\">USA</option>\n" +
                "    </select>\n" +
                "  \n" +
                "    <input type=\"submit\" value=\"Submit\">\n" +
                "  </form>\n" +
                "</div>");

        out.close();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    }
