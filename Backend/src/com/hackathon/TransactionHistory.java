package Backend.src.com.hackathon;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * Created by Marciana on 19.11.2015.
 */
public class TransactionHistory {
    private HashMap<String,ArrayList<Transaction>> history;
    private final int HISTORYDAYS=30;
    private final int RADIUS=10;


    public TransactionHistory() {
        history=new HashMap<>();
    }

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

    public int numberOfPurchasesNearby(String id, Location loc){
        if( !history.containsKey(id)){
            return 0;
        } else {
            int count=0;
            Calendar now= Calendar.getInstance();
            ArrayList<Transaction> hist= history.get(id);
            for(Transaction t: hist){
                double dist= loc.getDistance(t.getCustomer().getHome());
                long days=now.getTimeInMillis()-t.getTransactionTime().getTimeInMillis();
               if(dist<=RADIUS && days <=HISTORYDAYS){
                   count++;
               }
            }
            return count;
        }
    }
}
