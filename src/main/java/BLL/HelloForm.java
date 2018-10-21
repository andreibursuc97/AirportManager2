package BLL;

import dao.AdminDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="helloForm", urlPatterns="/HelloForm")
public class HelloForm extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminDAO loginDAO = new AdminDAO();
        if(loginDAO.login(username,password)) {
            Cookie message = new Cookie("Adminlogged", username);
            message.setMaxAge(60*60);
            response.addCookie(message);
            //request.setAttribute();
            //RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
            response.sendRedirect("/WelcomeServlet");
        }
        else
        {
            //RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            //request.setAttribute("errorMessage", "Invalid user or password");

//            response.sendRedirect("index.jsp");
            out.println("<meta http-equiv='refresh' content='2;URL=index.jsp'>");//redirects after 3 seconds
            out.println("<script type=\"text/javascript\">");
            out.println("alert('User or password incorrect');");
            out.println("location='index.jsp';");
            out.println("</script>");
//            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
//            rd.forward(request,response);

        }
    }
}
