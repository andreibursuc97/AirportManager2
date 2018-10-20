package Presentation;

import dao.LoginDAO;

public class Start {

    public static void main (String[] args)
    {
        LoginDAO loginDAO = new LoginDAO();
        loginDAO.login("admin","admin");
    }
}
