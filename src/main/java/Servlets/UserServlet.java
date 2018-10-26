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
        String arrivalCityTime="";
        String departureCityTime="";
        String arrivalCityName="";
        String departureCityName="";
        Constants constants = new Constants();
        for (Cookie cookie : cookies) {

            if ("ArrivalCityTime".equals(cookie.getName())) {
                arrivalCityTime=cookie.getValue();
            }

            if ("DepartureCityTime".equals(cookie.getName())) {
                departureCityTime=cookie.getValue();
            }

            if ("ArrivalCityName".equals(cookie.getName())) {
                arrivalCityName=cookie.getValue();
            }

            if ("DepartureCityName".equals(cookie.getName())) {
                departureCityName=cookie.getValue();
            }

            if("Userlogged".equals(cookie.getName())) {
                n = cookie.getValue();
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

        out.print("<h3>Add a new flight</h3>\n" +
                "\n" +
                "<div>\n" +
                "  <form action=\"HourTransformServlet\" method=\"GET\">\n" +
                "    <label for=\"flightIdLabel\">Flight Id</label><br>\n" +
                "    <select id=\"flightId\" name=\"flightId\">\n");


        for(FlightEntity flightEntity:flightEntities)
        {
            out.print("<option value=\"" + flightEntity.getId() + "\">" + flightEntity.getId() + "</option>\n");
        }

        out.print("    </select><br>\n"+
                "    <input type=\"submit\" name=\"action\" value=\"Local time\"><br>\n" +
                "  </form>\n"+ "</div>"
        );

        if(!arrivalCityTime.equals("") && !departureCityTime.equals("") )
        {
            out.print("<h3>"+ arrivalCityName+ ": " + arrivalCityTime + "</h3>"+
                    "<h3>" + departureCityName + ": " + departureCityTime + "</h3>");
        }
    }
}
