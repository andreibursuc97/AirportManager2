package BLL;

import dao.CityDao;
import model.CityEntity;

import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CityBLL {

    private final CityDao cityDao = new CityDao();

    public CityEntity getCityById(Integer cityId)
    {

        return cityDao.getCityById(cityId);
    }

    public List<CityEntity> getAllCities()
    {
        return cityDao.getAllCities();
    }

    public CityEntity insertCity(String cityName, String longitude, String latitude)
    {

        return cityDao.insertCity(new CityEntity(cityName,longitude,latitude));
    }
}
