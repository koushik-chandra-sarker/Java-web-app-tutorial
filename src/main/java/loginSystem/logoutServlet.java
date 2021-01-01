package loginSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logoutServlet",urlPatterns = "/logout")
public class logoutServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookie = new Cookie("username","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.sendRedirect("login");
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate"); // HTTP v1.1
        response.setHeader("Pragma","no-cache"); // HTTP 1.0
        response.setHeader("Expires","0"); //Proxies server
    }


}
