package Backend.src.com.hackathon;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Backend.");
        ApiConnection.curlURL("https://api.zalando.com/articles?category=cocktail-dresses&page=1&pageSize=10");
    }
}
