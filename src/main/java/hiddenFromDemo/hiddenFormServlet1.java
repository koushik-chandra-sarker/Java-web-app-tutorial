package hiddenFromDemo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "hiddenFormServlet1",urlPatterns = "/hiddenFormServlet1")
public class hiddenFormServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.getWriter().print("Hi "+name+". Welcome to UWServlet1.");
        response.setContentType("text/html");
        response.getWriter().print("<form action=\"hiddenFormServlet2\" method=\"get\">\n" +
                "    <input type=\"hidden\" name=\"name\" value='"+name+"'>\n" +
                "    <input type=\"submit\" value=\"Go to second Servlet\">\n" +
                "</form>");
    }
}
