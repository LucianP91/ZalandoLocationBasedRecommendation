package Backend.src.com.hackathon;

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

    public Location getHome() {
        return home;
    }
}
