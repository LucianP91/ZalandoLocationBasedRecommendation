package Backend.src.com.hackathon;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class TransactionHistory {
    private HashMap<String,ArrayList<Transaction>> history;

    private final int HISTORYDAYS=30;
    private final int RADIUS=10;


    public TransactionHistory() {
        history=new HashMap<>();
    }

    /**
     * Adds a new transaction to transaction history
     * @param id id of the item purchased
     * @param ip ip of customer who purchased
     */
    public void addTransaction(String id, String ip) {
        IpDetails ipDetails = ApiConnection.getIpDetails(ip);
        Location location = new Location(ipDetails.getLatitude(), ipDetails.getLongitude());
        User customer = new User("Dummy Firstname", location);
        addTransaction(id, customer);
    }

    private void addTransaction(String id, User customer){
        if( history.containsKey(id)){
            history.get(id).add(new Transaction(customer));
        }
        else {
            ArrayList<Transaction> hist = new ArrayList<>();
            hist.add(new Transaction(customer));
            history.put(id, hist);
        }
    }

    private int numberOfPurchasesNearby(String id, Location loc){
        if( !history.containsKey(id)){
            return 0;
        } else {
            int count=0;
            Calendar now= Calendar.getInstance();
            ArrayList<Transaction> hist= history.get(id);
            for(Transaction t: hist){
                double dist= loc.getDistance(t.getCustomer().getHome());
                long days= TimeUnit.MILLISECONDS.toDays(now.getTimeInMillis()-t.getTransactionTime().getTimeInMillis());
               if(dist<=RADIUS && days <=HISTORYDAYS){
                   count++;
               }
            }
            return count;
        }
    }

    /**
     * Calculate how many times items were bought within RADIUS of ip location within last HISTORYDAYS days
     * @param id id of the item customer is interested in
     * @param ip ip address the location search is based on
     * @return number of purchases
     */
    public int numberOfPurchasesNearby(String id, String ip){
        IpDetails ipd = ApiConnection.getIpDetails(ip);
        Location loc = new Location(ipd.getLatitude(),ipd.getLongitude());
        return numberOfPurchasesNearby(id, loc);
    }
}
