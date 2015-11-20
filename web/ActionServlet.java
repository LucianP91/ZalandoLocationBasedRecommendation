package web;

import Backend.src.com.hackathon.ApiConnection;
import Backend.src.com.hackathon.Dress;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "actionServlet")
public class ActionServlet extends HttpServlet {

    public void service(ServletRequest request,
                        ServletResponse response)
            throws ServletException, IOException {
        System.out.println("ActionDressServlet servie");
        ArrayList<Dress> dresses = ApiConnection.curlURL(ApiConnection.APIURL);

        Object id =  request.getParameter("dressid");
        Dress dress = dresses.get(0);
        for (Dress dress1 : dresses) {
            System.out.println(dress1 + "dressid: " + dress1.getId() + " id: " + id);
            if (id.equals(dress1.getId())) {
                dress = dress1;
                break;
            }
        }

        Object ip = request.getParameter("ip");

        System.out.println("schleife durchlaufen");
        request.setAttribute("bild", dress.getPictureUrl());
        request.setAttribute("preis", dress.getPrice());
        request.setAttribute("name", dress.getName());
        request.setAttribute("ip", ip);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("searchinput: " + request.getParameter("searchField"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("getausgabe");
    }
}
