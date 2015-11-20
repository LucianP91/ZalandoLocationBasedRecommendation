package Backend.src.com.hackathon;
import java.util.Calendar;

public class Transaction {
    Calendar transactionTime;
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
