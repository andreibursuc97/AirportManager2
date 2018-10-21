package dao;

import model.FlightEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class FlightDao {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public List<FlightEntity> getAllFlights()
    {
        Encrypt code = new Encrypt();

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("flight.getAllFlights");
        List<FlightEntity> flightEntityList = query.getResultList();

        entityManagerFactory.close();
        return flightEntityList;
    }
}
