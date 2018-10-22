package BLL;

import dao.CityDao;
import model.CityEntity;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name="AddCityServlet", urlPatterns="/AddCityServlet")
public class AddCityServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        CityDao cityDao = new CityDao();
        CityEntity cityEntity = new CityEntity(request.getParameter("cityName"),request.getParameter("longitude"),request.getParameter("latitude"));
        cityDao.insertCity(cityEntity);

        response.sendRedirect("/WelcomeServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type


    }
}
