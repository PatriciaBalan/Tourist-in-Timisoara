package firstproject.com.example.demo.model;

public class Restaurant {

    private int restaurantId;

    private String restaurantName;

    private String restaurantDetails;


    public Restaurant() {

    }

    public Restaurant(int restaurantId, String restaurantName, String restaurantDetails) {
        this.restaurantId=restaurantId;
        this.restaurantName=restaurantName;
        this.restaurantDetails=restaurantDetails;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId=restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName=restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName= this.restaurantName;
    }

    public String getRestaurantDetails() {
        return restaurantDetails;
    }

    public void setRestaurantDetails() {
        this.restaurantDetails=restaurantDetails;
    }

    @Override
    public String toString() {
    return "Restaurants{" +
            "restaurantId=" + restaurantId +
            ", restaurantName='" + restaurantName + '\'' +
            ", restaurantDetails='" + restaurantDetails + '\'' +
            '}';
    }
}

