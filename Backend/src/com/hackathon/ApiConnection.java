package Backend.src.com.hackathon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sun.org.apache.xerces.internal.xs.StringList;
import jdk.nashorn.internal.parser.JSONParser;

public class ApiConnection {
    public static void curlURL(String urlStr) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            System.out.println("START FETCHING.");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                response.append(line);
            }
            System.out.println("FETCHING DONE.");

        } catch (Exception e) {
            System.out.println("ERROR.");
        }


    }
}
