package presentation;

import BLL.LoginBLL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="helloForm", urlPatterns="/HelloForm")
public class HelloForm extends HttpServlet {

    private final LoginBLL loginBLL = new LoginBLL();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(loginBLL.login(username,password)==1) {
            Cookie message = new Cookie("Adminlogged", username);
            message.setMaxAge(60*60);
            response.addCookie(message);
            //request.setAttribute();
            //RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
            response.sendRedirect("/WelcomeServlet");
        }

        if(loginBLL.login(username,password)==2) {
            Cookie message = new Cookie("Userlogged", username);
            message.setMaxAge(60*60);
            response.addCookie(message);
            //request.setAttribute();
            //RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");
            response.sendRedirect("/UserServlet");
        }

        if(loginBLL.login(username,password)==0)
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
