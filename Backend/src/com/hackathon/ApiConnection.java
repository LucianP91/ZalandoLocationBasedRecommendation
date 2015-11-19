package Backend.src.com.hackathon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ApiConnection {

    /**
     * Fetches JSON and parses data to Dress objects.
     * @param urlStr The API url to fetch, e.g. https://api.zalando.com/articles?category=cocktail-dresses&page=1&pageSize=10.
     * @return An ArrayList of size 10 holding the parsed Dress objects.
     */
    public static ArrayList<Dress> curlURL(String urlStr) {
        ArrayList<Dress> res = new ArrayList<>();
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            System.out.println("Fetching url...");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                response.append(line);
            }
            System.out.println("Fetching done, decoding...");

            JSONObject json = (JSONObject)new JSONParser().parse(response.toString());

            JSONArray array = (JSONArray)json.get("content");
            for (int i=0; i < 10; i++) {
                JSONObject dress = (JSONObject) array.get(i);
                String id, name, price, pictureUrl;
                id = "" +dress.get("id");
                name = "" +dress.get("name");
                final JSONObject priceObj = (JSONObject)((JSONObject)((JSONArray)dress.get("units")).get(0)).get("price");
                price = "" +priceObj.get("formatted");
                final JSONArray imageArr = (JSONArray)((JSONObject)dress.get("media")).get("images");
                pictureUrl = "" +((JSONObject)imageArr.get(2)).get("largeUrl");
                res.add(new Dress(id, name, price, pictureUrl));
                System.out.println(res.get(i));
            }
            System.out.println("Decoding done..");


        } catch (Exception e) {
            System.out.println("ERROR.");
        }
        return res;
    }
}
