package Backend.src.com.hackathon;

public class Dress {
    private String id;
    private String name;
    private String price;
    private String pictureUrl;

    public Dress(String id, String name, String price, String pictureUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.pictureUrl = pictureUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    @Override
    public String toString() {
        return "[Dress] id=" +id +", name=" +name +", price=" +price +", pictureUrl=" +pictureUrl;
    }
}
