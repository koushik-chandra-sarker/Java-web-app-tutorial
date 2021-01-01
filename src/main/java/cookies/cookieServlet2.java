package cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "cookieServlet2",urlPatterns ="/cookieServlet2")
public class cookieServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "";
        response.setContentType("text/html");
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        for (Cookie c : cookies){
            if (c.getName().equals("user_name")){
                flag = true;
                name = c.getValue();
            }
        }
        if (flag){
            response.getWriter().print("Hi "+name+". Welcome to cookieServlet2.");
        }else {
            response.getWriter().print("There are no cookies available.");
        }



    }
}
