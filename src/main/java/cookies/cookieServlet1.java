package cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cookieServlet1",urlPatterns ="/cookieServlet1")
public class cookieServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");

        response.getWriter().print("Hi"+name+". Welcome to cookieServlet1.");
        response.setContentType("text/html");
        response.getWriter().print("<a href=\"cookieServlet2\"><button>Go to second servlet</button></a>");
        Cookie cookie = new Cookie("user_name",name);

        response.addCookie(cookie);
    }
}
