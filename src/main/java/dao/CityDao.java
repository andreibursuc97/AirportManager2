package dao;

import model.CityEntity;
import model.FlightEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class CityDao {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public CityEntity getCityById(Integer cityId)
    {
        Encrypt code = new Encrypt();

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        CityEntity cityEntity = entityManager.find(CityEntity.class,cityId);

        entityManagerFactory.close();
        return cityEntity;
    }
}
