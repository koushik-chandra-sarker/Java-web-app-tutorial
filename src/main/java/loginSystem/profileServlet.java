package loginSystem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "profileServlet",urlPatterns = "/profile")
public class profileServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        Cookie[] cookies = request.getCookies();
        String name ="";
        boolean flag = false;
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
        response.setHeader("Pragma","no-cache"); // HTTP 1.0
        response.setHeader("Expires","0"); //Proxies server
        if (cookies!=null){
            for (Cookie c : cookies){
                if (c.getName().equals("username")){
                    flag = true;
                    name = c.getValue();
                }
            }
        }

        if (flag){
            response.getWriter().print("Hi "+name+". You are successfully logged in.<br>");
            response.getWriter().print("<a href=\"about.html\"><button>about</button></a>");
            response.getWriter().print("<a href=\"logout\"><button>logout</button></a>");

        }else {
            response.sendRedirect("login");
        }
    }

}
