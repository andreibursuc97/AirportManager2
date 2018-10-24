package BLL;

import dao.AdminDAO;
import dao.ClientDAO;

public class LoginBLL {

    private AdminDAO adminDAO;
    private ClientDAO clientDAO;

    public LoginBLL() {

        adminDAO = new AdminDAO();
        clientDAO = new ClientDAO();
    }

    public int login(String username, String password)
    {
        if(adminDAO.login(username,password))
            return 1;
        if(clientDAO.login(username,password))
            return 2;
        return 0;
    }
}
