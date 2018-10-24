package BLL;

import dao.CityDao;
import dao.FlightDao;
import model.CityEntity;
import model.FlightEntity;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class FlightBLL {

    private final FlightDao flightDao = new FlightDao();
    private final CityDao cityDao = new CityDao();

    public List<FlightEntity> getAllFlights()
    {
        return flightDao.getAllFlights();
    }

    public void insertFlight(String airplaneType, String departureCity, String departureDate, String arrivalCity, String arrivalDate)
    {
        Integer departureCityId = Integer.parseInt(departureCity);
        Integer arrivalCityId = Integer.parseInt(arrivalCity);
        FlightEntity flightEntity = new FlightEntity(airplaneType,departureCityId,departureDate,arrivalCityId,arrivalDate);
        flightDao.insertFlight(flightEntity);
    }

    public void deleteFlight(String flightId)
    {
        //FlightEntity flightEntity = flightDao.getFlightById(Integer.parseInt(flightId));
        flightDao.deleteFlight(Integer.parseInt(flightId));
    }

    public void updateFlight(String flightId,String airplaneType, String departureCityId, String departureDate, String arrivalCityId, String arrivalDate)
    {
        FlightEntity flightEntity = flightDao.getFlightById(Integer.parseInt(flightId));
        if(!airplaneType.equals(""))
            flightEntity.setAirplaneType(airplaneType);

        flightEntity.setDepartureCityId(Integer.parseInt(departureCityId));

        if(!departureDate.equals(""))
            flightEntity.setDepartureDate(departureDate);

        flightEntity.setArrivalCityId(Integer.parseInt(arrivalCityId));

        if(!arrivalDate.equals(""))
            flightEntity.setArrivalDate(arrivalDate);
        flightDao.updateFlight(flightEntity);
    }

}
