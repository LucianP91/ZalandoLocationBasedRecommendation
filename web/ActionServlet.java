package web;

import Backend.src.com.hackathon.ApiConnection;
import Backend.src.com.hackathon.Dress;
import Backend.src.com.hackathon.TransactionHistory;

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

        String id =  (String)request.getParameter("dressid1");
        String ip = (String) request.getParameter("ip");
        Dress dress = dresses.get(0);
        for (Dress dress1 : dresses) {
            System.out.println(dress1 + "dressid: " + dress1.getId() + " id: " + id);
            if (id.equals(dress1.getId())) {
                dress = dress1;
                break;
            }
        }


        System.out.println("schleife durchlaufen");
        request.setAttribute("bild", dress.getPictureUrl());
        request.setAttribute("preis", dress.getPrice());
        request.setAttribute("name", dress.getName());
        request.setAttribute("id", id);
        request.setAttribute("ip", ip);

        if(TransactionHistory.numberOfPurchasesNearIp((String) id, ip) >= 2){
            request.setAttribute("warnung", "Das Kleid wurde in deiner Nähe schon verdammt oft gekauft! Kauf mal lieber was anderes.");
            request.setAttribute("htmlText", "<table><tr><td>" +
                    "<button type=\"button\" onclick=\"document.getElementById('dressid1').value='${dressid0}'; document.myForm.submit();\">\n" +
                    "   <img width=\"304px\" src=\"${pic0}\">\n" +
                    "</button>" +
                    "</td>" +
                    "<td>" +
                    "   bla bla" +
                    "</td><td>" +
                    "   mehr bla bla" +
                    "</td></tr></table>");
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("searchinput: POST BLA BLA BLA");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
System.out.println("getausgabe");
    }
}
