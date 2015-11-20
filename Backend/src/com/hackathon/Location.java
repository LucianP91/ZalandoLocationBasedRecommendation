package Backend.src.com.hackathon;

/**
 * Representation of a location
 */
public class Location {
    private double longitude, latitude;
    private final double R = 6373d;
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

    /**
     * Calulates distance to given location
     * @param to location we want to have distance to
     * @return returns straight-line distance in kilometers
     */
    public double getDistance(Location to){
       double dlon=Math.toRadians(to.getLongitude()-this.getLongitude());
        double dlat= Math.toRadians(to.getLatitude()-this.getLatitude());
        double a=Math.pow(Math.sin(dlat/2),2)+Math.cos(Math.toRadians(to.getLatitude()))*Math.cos(Math.toRadians(this.getLatitude()))*Math.pow(Math.sin(dlon/2),2);
        double c = 2* Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        return R *c;
    }
}
