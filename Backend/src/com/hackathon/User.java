package Backend.src.com.hackathon;
import Backend.src.com.hackathon.Location;

public class User {
    private String firstName;
    private Location home;

    public User(String firstName, Location home) {
        this.firstName = firstName;
        this.home = home;
    }

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
