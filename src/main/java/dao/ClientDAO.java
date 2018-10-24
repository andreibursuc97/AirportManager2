package dao;

import model.AdministratorEntity;
import model.ClientsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ClientDAO {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public boolean login(String username, String parola)
    {
        Encrypt code = new Encrypt();

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("ClientsEntity.findByUsername");
        query.setParameter("username", username);
        List<ClientsEntity> clientsEntityList = query.getResultList();
        if (clientsEntityList.isEmpty()) {
            System.out.println("Username gresit user");
            return false;
        }
        ClientsEntity client = clientsEntityList.get(0);

        System.out.println(code.codeToString(client.getPasswordClient()));
        System.out.println(code.codeToString(code.code(parola)));
        if (!code.codeToString(client.getPasswordClient()).equals(code.codeToString(code.code(parola)))) {
            System.out.println("Parola Gresita user");
            return false;
        }
        entityManagerFactory.close();
        return true;
    }
}
