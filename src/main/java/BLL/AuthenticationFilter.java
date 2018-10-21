package BLL;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebFilter(filterName = "AdminFilter", urlPatterns = "/WelcomeServlet",servletNames = "WelcomeServlet")
public class AuthenticationFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        //HttpSession session = req.getSession(false);

//        if (session==null || !session.getAttribute("LoggedIn").equals("true")) {   //checking whether the session exists
//            this.context.log("Unauthorized access request");
//            res.sendRedirect(req.getContextPath() + "/index.jsp");
//        } else {
//            // pass the request along the filter chain
//            chain.doFilter(request, response);
//        }
        Cookie[] cookies = req.getCookies();
        Cookie loginCookie=null;
        for (Cookie cookie : cookies) {

            if ("Adminlogged".equals(cookie.getName())) {
                loginCookie = cookie;
            }
        }
        if(loginCookie==null)//req.getParameter("Adminlogged")==null)
        {
            this.context.log("Unauthorized access request");
            res.sendRedirect(req.getContextPath() + "/index.jsp");
        } else {
            // pass the request along the filter chain
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
        //close any resources here
    }
}
