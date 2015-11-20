package Backend.src.com.hackathon;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Locale;

public class ApiConnection {
    public final static String APIURL = "https://api.zalando.com/articles?category=cocktail-dresses&page=1&pageSize=10";

    /**
     * Fetches the given URL.
     * @param urlStr The URL to fetch.
     * @return Response as String.
     */
    private static String fetchUrl(String urlStr) {
        StringBuilder response = new StringBuilder();
        try {
            URL url = new URL(urlStr);
            URLConnection urlConnection = url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;
            System.out.println("Fetching url...");
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                response.append(line);
            }
            System.out.println("Fetching done.");
        } catch (Exception e) {
            System.err.println("Error fetching url:" +urlStr);
        }
        return response.toString();
    }

    /**
     * Fetches JSON and parses data to Dress objects.
     * @param urlStr The API url to fetch, e.g. https://api.zalando.com/articles?category=cocktail-dresses&page=1&pageSize=10.
     * @return An ArrayList of size 10 holding the parsed Dress objects.
     */
    public static ArrayList<Dress> curlURL(String urlStr) {
        ArrayList<Dress> res = new ArrayList<>();

        String response = fetchUrl(urlStr);

        JSONObject json;
        try {
            json = (JSONObject) new JSONParser().parse(response);
        } catch (ParseException e) {
            System.err.println("Error parsing JSON.");
            System.err.println("" +response);
            return res;
        }

        JSONArray array = (JSONArray)json.get("content");
        for (int i=0; i < 10; i++) {
            JSONObject dress = (JSONObject) array.get(i);
            String id, name, price, pictureUrl;
            id = "" +dress.get("id");
            name = "" +dress.get("name");
            final JSONObject priceObj = (JSONObject)((JSONObject)((JSONArray)dress.get("units")).get(0)).get("price");
            price = ("" +priceObj.get("formatted")).replace('£', (char)163);
            final JSONArray imageArr = (JSONArray)((JSONObject)dress.get("media")).get("images");
            pictureUrl = "" +((JSONObject)imageArr.get(2)).get("largeUrl");
            res.add(new Dress(id, name, price, pictureUrl));
            System.out.println(res.get(i));
        }
        return res;
    }

    /**
     * Fetches the ip details via http://freegeoip.net/
     * @param ip The IPv4 address to fetch.
     * @return An IpDetail object holding ip, name, latitude and longitude, or holding only an ip on error.
     */
    public static IpDetails getIpDetails(String ip) {
        String response = fetchUrl("http://freegeoip.net/json/" +ip);
        JSONObject json;
        try {
            json = (JSONObject) new JSONParser().parse(response);
        } catch (ParseException e) {
            System.err.println("Error parsing JSON.");
            System.err.println("" +response);
            return new IpDetails(ip, "", 0, 0);
        }
        String city = "" +json.get("city");
        double latitude = (Double) json.get("latitude");
        double longitude = (Double) json.get("longitude");
        return new IpDetails(ip, city, latitude, longitude);
    }
}
