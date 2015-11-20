package Backend.src.com.hackathon;

public class IpDetails {
    private String ip;
    private String city;
    private double latitude;
    private double longitude;

    public IpDetails(String ip, String city, double latitude, double longitude) {
        this.ip = ip;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getIp() {
        return ip;
    }

    public String getCity() {
        return city;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "[IpDetail] ip=" +ip +", city=" +city +", latitude=" +latitude +", longitude=" +longitude;
    }
}
