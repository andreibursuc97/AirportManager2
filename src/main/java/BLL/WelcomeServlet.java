package BLL;

import dao.CityDao;
import dao.FlightDao;
import model.CityEntity;
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
        Constants constants = new Constants();
        for (Cookie cookie : cookies) {

            if ("Adminlogged".equals(cookie.getName())) {
                n=cookie.getValue();
            }
        }
        out.print(constants.getAdminCss());
        out.print("<h3>Welcome " + n + "</h3>");
        out.print(constants.getAdminLogOutButton());
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

        out.print("<h3>Add a new flight</h3>\n" +
                "\n" +
                "<div>\n" +
                "  <form action=\"/action_page.php\">\n" +
                "    <label for=\"aType\">Airplane type</label><br>\n" +
                "    <input type=\"text\" id=\"airplaneType\" name=\"airplaneType\" placeholder=\"Airplane type..\"><br>\n" +
                "\n" +
                "    <label for=\"dCity\">Departure City</label><br>\n" +
                "    <select id=\"departureCity\" name=\"departureCity\">\n");

//                "      <option value=\"australia\">Australia</option>\n" +
//                "      <option value=\"canada\">Canada</option>\n" +
//                "      <option value=\"usa\">USA</option>\n" +
        List<CityEntity> cityEntities = cityDao.getAllCities();

        for(CityEntity cityEntity: cityEntities)
        {
            out.print("<option value=\"" + cityEntity.getId() + "\">" + cityEntity.getCityName() + "</option>\n");
        }

        out.print("    </select><br>\n" +
                "    <label for=\"arrivalDate\">Arrival Date</label><br>\n" +
                "    <input type=\"text\" id=\"arrivalDate\" name=\"arrivalDate\" placeholder=\"Arrival Date..\"><br>\n"+
                "    <label for=\"aCity\">Arrival City</label><br>\n" +
                "    <select id=\"arrivalCity\" name=\"arrivalCity\">\n");

        for(CityEntity cityEntity: cityEntities)
        {
            out.print("<option value=\"" + cityEntity.getId() + "\">" + cityEntity.getCityName() + "</option>\n");
        }

        out.print("    </select><br>\n" +
                "    <label for=\"arrivalDate\">Arrival Date</label><br>\n" +
                "    <input type=\"text\" id=\"arrivalDate\" name=\"arrivalDate\" placeholder=\"Arrival Date..\"><br>\n" +
                "    <input type=\"submit\" value=\"Insert\"><br>\n" +
                "  </form>\n" //+ "</div>"
                );

        out.print(
//                "<div style='float:left'>\n" +
                "<h3>Insert new city</h3>\n" +
                "\n" +
                "  <form action=\"AddCityServlet\" method=\"POST\">\n" +
                "    <label for=\"City\">City Name</label><br>\n" +
                "    <input type=\"text\" id=\"cityName\" name=\"cityName\" placeholder=\"City name..\"><br>\n" +
                "\n" +
                "    <label for=\"longitude\">Longitude</label><br>\n" +
                "    <input type=\"text\" id=\"longitude\" name=\"longitude\" placeholder=\"longitude..\"><br>\n" + "\n" +
                "    <label for=\"latitude\">Latitude</label><br>\n" +
                "    <input type=\"text\" id=\"latitude\" name=\"latitude\" placeholder=\"Latitude..\"><br>\n" +
                "    <input type=\"submit\" value=\"Insert\"><br>\n" +
                "  </form>\n" +
                "</div>");

        out.close();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);
    }
    }
