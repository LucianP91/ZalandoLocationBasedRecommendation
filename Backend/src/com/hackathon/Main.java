package Backend.src.com.hackathon;

public class Main {
    private final static String APIURL = "https://api.zalando.com/articles?category=cocktail-dresses&page=1&pageSize=10";

    public static void main(String[] args) {
        System.out.println("Hello Backend.");
        ApiConnection.curlURL(APIURL);
    }
}
