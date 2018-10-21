package Presentation;

import dao.AdminDAO;

public class Start {

    public static void main (String[] args)
    {
        AdminDAO loginDAO = new AdminDAO();
        loginDAO.login("admin","admin");
    }
}
