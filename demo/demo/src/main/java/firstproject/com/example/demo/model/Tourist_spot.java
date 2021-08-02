package firstproject.com.example.demo.model;

import javax.persistence.*;

@Entity(name="Tourist_spot")
@Table(name="tourist_spot")
public class Tourist_spot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int spotId;

    @Column
    private String spotName;

    @Column
    private String spotDetail;

    public Tourist_spot() {
    }

    public Tourist_spot(int spotId, String spotName, String spotDetail) {
        this.spotId = spotId;
        this.spotName = spotName;
        this.spotDetail = spotDetail;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public String getSpotName() {
        return spotName;
    }

    public void setSpotName(String spotName) {
        this.spotName = spotName;
    }

    public String getSpotDetail() {
        return spotDetail;
    }

    public void setSpotDetail(String spotDetail) {
        this.spotDetail = spotDetail;
    }

    @Override
    public String toString() {
        return "Tourist_spot{" +
                "spotId=" + spotId +
                ", spotName='" + spotName + '\'' +
                ", spotDetail='" + spotDetail + '\'' +
                '}';
    }
}
