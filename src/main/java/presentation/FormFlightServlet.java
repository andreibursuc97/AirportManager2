package presentation;

import BLL.FlightBLL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="FormFlightServlet", urlPatterns="/FormFlightServlet")
public class FormFlightServlet extends HttpServlet {

    private final FlightBLL flightBLL = new FlightBLL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String action = request.getParameter("action");
        String flightId = request.getParameter("flightId");
        String airplaneType = request.getParameter("airplaneType");
        String departureCityId = request.getParameter("departureCity");
        String departureDate = request.getParameter("departureDate");
        String arrivalCityId = request.getParameter("arrivalCity");
        String arrivalDate = request.getParameter("arrivalDate");
        if(action.equals("Insert"))
        {
            flightBLL.insertFlight(airplaneType,departureCityId,departureDate,arrivalCityId,arrivalDate);
        }

        if(action.equals("Delete"))
        {
            flightBLL.deleteFlight(flightId);
        }

        if(action.equals("Update"))
        {
            flightBLL.updateFlight(flightId,airplaneType,departureCityId,departureDate,arrivalCityId,arrivalDate);
        }


        response.sendRedirect("/WelcomeServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type


    }
}
