package dao;

import model.AdministratorEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LoginDAO {

    EntityManager entityManager;
    EntityManagerFactory entityManagerFactory;

    public boolean login(String username, String parola)
    {
        Encrypt code = new Encrypt();

        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");
        entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNamedQuery("administrator.findByUsername");
        query.setParameter("username", username);
        List<AdministratorEntity> adminEntityList = query.getResultList();
        if (adminEntityList.isEmpty()) {
            System.out.println("Username gresit");
            return false;
        }
        AdministratorEntity admin = adminEntityList.get(0);

        System.out.println(code.codeToString(admin.getPasswordAdmin()));
        System.out.println(code.codeToString(code.code(parola)));
        if (!code.codeToString(admin.getPasswordAdmin()).equals(code.codeToString(code.code(parola)))) {
            System.out.println("Parola Gresita");
            return false;
        }
        entityManagerFactory.close();
        return true;
    }
}
