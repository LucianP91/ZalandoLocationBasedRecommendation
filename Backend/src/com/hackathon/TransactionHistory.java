package Backend.src.com.hackathon;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * Class to keep trach of recent transactions
 */
public class TransactionHistory {
    /**
     * Hashmap keeping track of transactions
     */
    private HashMap<String,ArrayList<Transaction>> history;
    /**
     * Number of look-back days
     */
    private final int HISTORYDAYS=30;
    /**
     * radius of serach
     */
    private final int RADIUS=10;


    public TransactionHistory() {
        history=new HashMap<>();
    }

    /**
     * Add a new transaction to transaction history
     * @param id id of the item purchased
     * @param customer customer who purchased
     */
    public void addTransaction(String id, User customer){
        if( history.containsKey(id)){
            history.get(id).add(new Transaction(customer));
        }
        else {
            ArrayList<Transaction> hist = new ArrayList<Transaction>();
            hist.add(new Transaction(customer));
            history.put(id, hist);
        }
    }

    /**
     * Calculate how many times item with given id was bought within RADIUS of Loc within last HISTORYDAYS days
     * @param id id of the item customer is interested in
     * @param loc location the local search is based on
     * @return number of purchases
     */
    public int numberOfPurchasesNearby(String id, Location loc){
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
    public int numberOfPurchasesNearby(String id, String ip){
        IpDetails ipd = ApiConnection.getIpDetails(ip);
        Location loc = new Location(ipd.getLatitude(),ipd.getLongitude());
        return numberOfPurchasesNearby(id, loc);
    }
}
