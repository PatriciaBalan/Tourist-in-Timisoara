package firstproject.com.example.demo.model;

import javax.persistence.*;

@Entity(name="Transport")
@Table(name="transport")
public class Transport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int transportId;

    @Column
    private String transportType;

    @Column
    private String transportDetail;

    public Transport() {
    }

    public Transport(int transportId, String transportType, String transportDetail) {
        this.transportId = transportId;
        this.transportType = transportType;
        this.transportDetail = transportDetail;
    }

    public int getTransportId() {
        return transportId;
    }

    public void setTransportId(int transportId) {
        this.transportId = transportId;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getTransportDetail() {
        return transportDetail;
    }

    public void setTransportDetail(String transportDetail) {
        this.transportDetail = transportDetail;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "transportId=" + transportId +
                ", transportType='" + transportType + '\'' +
                ", transportDetail='" + transportDetail + '\'' +
                '}';
    }
}
