package Backend.src.com.hackathon;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello Backend.");
        //ApiConnection.curlURL(APIURL);
        //System.out.println(ApiConnection.getIpDetails("134.61.129.229"));
        //ApiConnection.curlURL(APIURL);
        Location Aachen= new Location(50.7753455,6.0838868);
        Location Berlin = new Location(52.519171,13.4060912);
        Location Wuerselen=new Location(50.8216502,6.1320672);
        User Marcel = new User("Marcel",Aachen);
        User Martin = new User ("Martin", Wuerselen);
        User Anja = new User ("Anja", Berlin);
        TransactionHistory h = new TransactionHistory();
        h.addTransaction("1", Marcel);
        h.addTransaction("1", Marcel);
        h.addTransaction("2", Martin);
        h.addTransaction("1", Martin);
        h.addTransaction("1", Anja);
        System.out.println(h.numberOfPurchasesNearby("2",Aachen));
    }
}
