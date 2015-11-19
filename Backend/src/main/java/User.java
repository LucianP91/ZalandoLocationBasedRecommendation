package main.java;
import main.java.Location;

/**
 * Created by Marciana on 19.11.2015.
 */
public class User {
    private String firstName;
    private Location home;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Location getHome() {
        return home;
    }

    public void setHome(Location home) {
        this.home = home;
    }
}
