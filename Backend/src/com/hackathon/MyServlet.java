package Backend.src.com.hackathon;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet
public class MyServlet extends HttpServlet{
    private String msg;

    public void init() throws ServletException {
        System.out.println("Server initialized. This is the init call");
        msg = "STFU";
    }

    public void service(ServletRequest request,
                        ServletResponse response)
            throws ServletException, IOException {
        System.out.println("MyServlet: service");
        request.setAttribute("myKey", "myVariable");
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Servlet: doGet");
        request.setAttribute("myKey", "myVariable");
        System.out.println(request.getAttribute("searchField"));
    }

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println(request.getAttribute("searchField"));
        // Servlet code
    }
}
