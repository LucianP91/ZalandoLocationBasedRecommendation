package Backend.src.com.hackathon;
import Backend.src.com.hackathon.Location;
import java.util.Calendar;
/**
 * Created by Marciana on 19.11.2015.
 * Representation of an Transaction
 */
public class Transaction {
    /**
     * Time of the transaction
     */
    Calendar transactionTime;
    /**
     * Customer who initialized transaction
     */
    User customer;

    public Transaction(User customer) {
        this.customer = customer;
        this.transactionTime = Calendar.getInstance();
    }

    public Calendar getTransactionTime() {

        return transactionTime;
    }

    public User getCustomer() {
        return customer;
    }
}
