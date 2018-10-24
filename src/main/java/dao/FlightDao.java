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
        Query query = entityManager.createNamedQuery("FlightEntity.getAllFlights");
        List<FlightEntity> flightEntityList = query.getResultList();

        entityManagerFactory.close();
        return flightEntityList;
    }

    public FlightEntity getFlightById(int flightId)
    {
        Encrypt code = new Encrypt();

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("FlightEntity.getFlightById");
        query.setParameter("id",flightId);
        List<FlightEntity> flightEntityList = query.getResultList();

        entityManagerFactory.close();
        return flightEntityList.get(0);
    }

    public void insertFlight(FlightEntity flightEntity)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(flightEntity);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

    }

    public void updateFlight(FlightEntity flightEntity)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(flightEntity);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

    }

    public void deleteFlight(int flightId)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Query query = entityManager.createNamedQuery("FlightEntity.deleteFlight");
        query.setParameter("id",flightId);
        query.executeUpdate();
        entityManager.getTransaction().commit();

        entityManagerFactory.close();

    }
}
