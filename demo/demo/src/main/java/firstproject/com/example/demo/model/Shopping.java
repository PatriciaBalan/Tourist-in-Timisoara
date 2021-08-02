package firstproject.com.example.demo.model;

import javax.persistence.*;

@Entity(name="Shopping")
@Table(name="shopping")
public class Shopping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int shopId;

    @Column
    private String shopName;

    @Column
    private String shopDetail;


    public Shopping() {

    }

    public Shopping(int shopId, String shopName, String shopDetail) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopDetail = shopDetail;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopDetail() {
        return shopDetail;
    }

    public void setShopDetail(String shopDetail) {
        this.shopDetail = shopDetail;
    }

    @Override
    public String toString() {
        return "Shopping{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", shopDetail='" + shopDetail + '\'' +
                '}';
    }
}
