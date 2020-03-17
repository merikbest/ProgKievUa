import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Solution extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String age = req.getParameter("age");
        String java = req.getParameter("java");
        String cookies = req.getParameter("cookies");

        PrintWriter writer = resp.getWriter();
        writer.println("<p>Name: " + name + "</p>");
        writer.println("<p>LastName: " + lastName + "</p>");
        writer.println("<p>Age: " + age + "</p>");
        writer.println("<p>Do you like java?: " + java + "</p>");
        writer.println("<p>Do you like cookies?: " + cookies + "</p>");
    }
}