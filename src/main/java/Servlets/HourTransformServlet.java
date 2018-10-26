package Servlets;

import BLL.CityBLL;
import BLL.FlightBLL;
import model.CityEntity;
import model.FlightEntity;
import model.TimeZoneDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.channels.FileLock;

@WebServlet(name="HourTransformServlet", urlPatterns="/HourTransformServlet")
public class HourTransformServlet extends HttpServlet {

    private final CityBLL cityBLL = new CityBLL();
    private final FlightBLL flightBLL = new FlightBLL();

    private static final String baseEarthToolsURL=
            "http://www.new.earthtools.org/timezone/";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        FlightEntity flightEntity = flightBLL.getFlightById((String)request.getParameter("flightId"));
        CityEntity arrivalCityEntity = cityBLL.getCityById(flightEntity.getArrivalCityId());
        CityEntity departureCityEntity = cityBLL.getCityById(flightEntity.getDepartureCityId());

        StringBuilder strBufArrival = getTimeRequest(response,arrivalCityEntity);
        StringBuilder strBufDeparture = getTimeRequest(response,departureCityEntity);
        //System.out.println(strBuf.toString());


        TimeZoneDTO timeZoneDTOArrival = JAXB.unmarshal(new StringReader(strBufArrival.toString()), TimeZoneDTO.class);
        TimeZoneDTO timeZoneDTODeparture = JAXB.unmarshal(new StringReader(strBufDeparture.toString()), TimeZoneDTO.class);

        //System.out.println(timeZoneDTO.getLocalTime());
        Cookie message = new Cookie("ArrivalCityTime", timeZoneDTOArrival.getLocalTime().replaceAll(" ","-"));
        message.setMaxAge(60*60);
        response.addCookie(message);

        message = new Cookie("ArrivalCityName", arrivalCityEntity.getCityName().replaceAll(" ","-"));
        message.setMaxAge(60*60);
        response.addCookie(message);

        message = new Cookie("DepartureCityTime", timeZoneDTODeparture.getLocalTime().replaceAll(" ","-"));
        message.setMaxAge(60*60);
        response.addCookie(message);

        message = new Cookie("DepartureCityName", departureCityEntity.getCityName().replaceAll(" ","-"));
        message.setMaxAge(60*60);
        response.addCookie(message);

        //request.setAttribute();
        //RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
        response.sendRedirect("/UserServlet");
    }

    private StringBuilder getTimeRequest(HttpServletResponse response,CityEntity cityEntity) throws IOException {

        String requestUrl = baseEarthToolsURL+cityEntity.getLatitude().replaceAll("\\s","")+"/"+cityEntity.getLongitude().replaceAll("\\s","");
        response.setContentType("text/html");

        StringBuilder strBuf = new StringBuilder();
        HttpURLConnection conn=null;
        BufferedReader reader=null;

        URL url = new URL(requestUrl);
        conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/xml");
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("HTTP GET Request Failed with Error code : "
                    + conn.getResponseCode());
        }
        reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));


        String output = null;
        while ((output = reader.readLine()) != null)
            strBuf.append(output);
        return strBuf;
    }
}
