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
import java.util.ArrayList;

@WebServlet
public class MyServlet extends HttpServlet{
    private String msg;

    public void init() throws ServletException {
        System.out.println("Server initialized. This is the init call");
    }

    public void service(ServletRequest request,
                        ServletResponse response)
            throws ServletException, IOException {
        System.out.println("MyServlet: service");

        ArrayList<Dress> dresses = ApiConnection.curlURL(ApiConnection.APIURL);

        for(int i=0; i<dresses.size(); i++){
            request.setAttribute("dress" + i, dresses.get(i).getName());
            request.setAttribute("pic"+i, dresses.get(i).getPictureUrl());
            request.setAttribute("dressid"+i, dresses.get(i).getId());
        }
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
