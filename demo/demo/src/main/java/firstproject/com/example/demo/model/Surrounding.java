package firstproject.com.example.demo.model;

import javax.persistence.*;

@Entity(name="Surrounding")
@Table(name="surrounding")
public class Surrounding {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int surroundingId;
    @Column
    private String surroundingName;
    @Column
    private String surroundingDetail;


    public Surrounding() {
    }

    public Surrounding(int surroundingId, String surroundingName, String surroundingDetail) {
        this.surroundingId = surroundingId;
        this.surroundingName = surroundingName;
        this.surroundingDetail = surroundingDetail;
    }

    public int getSurroundingId() {
        return surroundingId;
    }

    public void setSurroundingId(int surroundingId) {
        this.surroundingId = surroundingId;
    }

    public String getSurroundingName() {
        return surroundingName;
    }

    public void setSurroundingName(String surroundingName) {
        this.surroundingName = surroundingName;
    }

    public String getSurroundingDetail() {
        return surroundingDetail;
    }

    public void setSurroundingDetail(String surroundingDetail) {
        this.surroundingDetail = surroundingDetail;
    }

    @Override
    public String toString() {
        return "Surrounding{" +
                "surroundingId=" + surroundingId +
                ", surroundingName='" + surroundingName + '\'' +
                ", surroundingDetail='" + surroundingDetail + '\'' +
                '}';
    }
}

