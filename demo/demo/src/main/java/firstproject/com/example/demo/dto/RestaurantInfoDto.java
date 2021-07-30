package firstproject.com.example.demo.dto;

public class RestaurantInfoDto {

    private int restaurantId;

    private String restaurantName;

    private String restaurantDetail;

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantDetail() {
        return restaurantDetail;
    }

    public void setRestaurantDetail(String restaurantDetail) {
        this.restaurantDetail = restaurantDetail;
    }
}
