package Backend.src.com.hackathon;

/**
 * Created by Marciana on 19.11.2015.
 */
public class Location {
    private int x,y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getDistance(Location to){
      return  Math.sqrt( Math.pow(to.getX()-this.getX(),2) + Math.pow(to.getY()-this.getY(),2));
    }

 public static void main(String[] args){
     Location l1= new Location(0,0);
     Location l2 = new Location(5,2);
     System.out.println(l1.getDistance(l2));
 }
}
