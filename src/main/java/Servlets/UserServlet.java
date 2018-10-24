package Servlets;

import BLL.CityBLL;
import BLL.Constants;
import BLL.FlightBLL;
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

@WebServlet(name="UserServlet", urlPatterns="/UserServlet")
public class UserServlet extends HttpServlet {

    private final FlightBLL flightBLL = new FlightBLL();
    private final CityBLL cityBLL = new CityBLL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Cookie[] cookies = request.getCookies();
        String n="";
        Constants constants = new Constants();
        for (Cookie cookie : cookies) {

            if ("Userlogged".equals(cookie.getName())) {
                n=cookie.getValue();
            }
        }
        out.print(constants.getAdminCss());
        out.print("<h3>Welcome " + n + "</h3>");
        out.print(constants.getUserLogOutButton());
        out.print("<table id=\"customers\">\n" +
                "  <tr>\n" +
                "    <th>Id</th>\n" +
                "    <th>Airplane type</th>\n" +
                "    <th>Departure city</th>\n" +
                "    <th>Departure date</th>\n" +
                "    <th>Arrival city</th>\n" +
                "    <th>Arrival date</th>\n" +
                "  </tr>\n");
        List<FlightEntity> flightEntities = flightBLL.getAllFlights();

        for(FlightEntity flightEntity:flightEntities)
        {
            out.print("<tr>\n" +
                    "    <td>"+ flightEntity.getId() +"</td>\n" +
                    "    <td>"+ flightEntity.getAirplaneType() +"</td>\n" +
                    "    <td>"+ cityBLL.getCityById(flightEntity.getDepartureCityId()).getCityName() +"</td>\n" +
                    "    <td>"+ flightEntity.getDepartureDate() +"</td>\n" +
                    "    <td>"+ cityBLL.getCityById(flightEntity.getArrivalCityId()).getCityName() +"</td>\n" +
                    "    <td>"+ flightEntity.getArrivalDate() +"</td>\n" +
                    "  </tr>");
        }

        out.print("</table>");

    }
}
