package urlReW;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "uWServlet1",urlPatterns = "/uwservlet1")
public class uWServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.getWriter().print("Hi "+name+". Welcome to UWServlet1.");
        response.setContentType("text/html");
        response.getWriter().print("<a href=\"uwservlet2?name="+name+"\"><button>Go to second servlet</button></a>");
    }
}
