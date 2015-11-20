package Backend.src.com.hackathon;

/**
 * Created by Marciana on 19.11.2015.
 */
public class Location {
    private double longitude, latitude;
    private final int R = 6373;
    public Location( double latitude, double longitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {

        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getDistance(Location to){
       double dlon=Math.toRadians(to.getLongitude()-this.getLongitude());
        double dlat= Math.toRadians(to.getLatitude()-this.getLatitude());
        double a=Math.pow(Math.sin(dlat/2),2)+Math.cos(Math.toRadians(to.getLatitude()))*Math.cos(Math.toRadians(this.getLatitude()))*Math.pow(Math.sin(dlon/2),2);
        double c = 2* Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        return R *c;
    }

 public static void main(String[] args){
     Location Aachen= new Location(50.7753455,6.0838868);
     Location Berlin = new Location(52.519171,13.4060912);
     System.out.println(Aachen.getDistance(Berlin));
 }
}
