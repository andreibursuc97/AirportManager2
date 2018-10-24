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

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        CityEntity cityEntity = entityManager.find(CityEntity.class,cityId);

        entityManagerFactory.close();
        return cityEntity;
    }

    public List<CityEntity> getAllCities()
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("CityEntity.getAllCities");
        List<CityEntity> cityEntityList = query.getResultList();

        entityManagerFactory.close();
        return cityEntityList;
    }

    public CityEntity insertCity(CityEntity cityEntity)
    {

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(cityEntity);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
        return cityEntity;
    }

    public CityEntity getCityByName(String cityName)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("CityEntity.getCityByName");
        query.setParameter("cityName",cityName);
        List<CityEntity> cityEntityList = query.getResultList();

        entityManagerFactory.close();
        return cityEntityList.get(0);
    }
}
