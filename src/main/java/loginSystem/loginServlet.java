package loginSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class loginServlet extends HttpServlet {

    List<User> users = Arrays.asList(
            new User("user1","1111"),
            new User("user2","2222"),
            new User("user3","3333"),
            new User("user4","4444")
    );

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uName = request.getParameter("username");
        String pass = request.getParameter("password");
        response.setContentType("text/html");
       long count = users.stream().filter(e->e.getUsername().equals(uName)&&e.getPassword().equals(pass)).count();
        if (count>0){

            Cookie cookie = new Cookie("username",uName);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
            response.sendRedirect("profile");
            response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
            response.setHeader("Pragma","no-cache"); // HTTP 1.0
            response.setHeader("Expires","0"); //Proxies server
        }else {
            response.getWriter().print("Invalid username or password.");
            request.getRequestDispatcher("login1.html").include(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login1.html");
    }
}
  