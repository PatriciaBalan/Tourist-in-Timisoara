package firstproject.com.example.demo.model;

import javax.persistence.*;

@Entity(name="Restaurant")
@Table(name="restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int restaurantId;

    @Column
    private String restaurantName;

    @Column
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

    public void setRestaurantDetails(String restaurantDetails) {
        this.restaurantDetails= this.restaurantDetails;
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

