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

        String id = (String) request.getParameter("dressid1");
        String ip = (String) request.getParameter("ip");

        Dress dress = ApiConnection.getDressForId(id);


        System.out.println("schleife durchlaufen");
        request.setAttribute("bild", dress.getPictureUrl());
        request.setAttribute("preis", dress.getPrice());
        request.setAttribute("name", dress.getName());
        request.setAttribute("id", id);
        request.setAttribute("ip", ip);

        if (TransactionHistory.numberOfPurchasesNearIp(id, ip) >= TransactionHistory.PURCHASE_THRESHOLD) {
            ArrayList<Dress> recDress = ApiConnection.getRecommendationsWithLowNumberOfPurchases(id, ip);
            request.setAttribute("warnung", "Das Kleid wurde in deiner Nähe schon verdammt oft gekauft! Kauf mal lieber was anderes.");
            if (recDress != null && recDress.get(0) != null && recDress.get(1) != null && recDress.get(2) != null) {
                request.setAttribute("htmlText", "<table><tr><td>" +
                        recDress.get(0).getName() + "<br>" +
                        "<button type=\"button\" onclick=\"document.getElementById('dressid1').value='" + recDress.get(0).getId() + "'; document.myForm.submit();\">\n" +
                        "   <img width=\"104px\" src=\"" + recDress.get(0).getPictureUrl() + "\">\n" +
                        "</button>" +
                        "</td>" +
                        "<td>" +
                        recDress.get(1).getName() + "<br>" +
                        "<button type=\"button\" onclick=\"document.getElementById('dressid1').value='" + recDress.get(1).getId() + "'; document.myForm.submit();\">\n" +
                        "   <img width=\"104px\" src=\"" + recDress.get(1).getPictureUrl() + "\">\n" +
                        "</button>" +
                        "</td><td>" +
                        recDress.get(2).getName() + "<br>" +
                        "<button type=\"button\" onclick=\"document.getElementById('dressid1').value='" + recDress.get(2).getId() + "'; document.myForm.submit();\">\n" +
                        "   <img width=\"104px\" src=\"" + recDress.get(2).getPictureUrl() + "\">\n" +
                        "</button>" +
                        "</td></tr></table>");
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("searchinput: POST BLA BLA BLA");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getausgabe");
    }
}
