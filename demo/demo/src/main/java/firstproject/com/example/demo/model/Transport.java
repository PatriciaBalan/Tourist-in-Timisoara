package firstproject.com.example.demo.model;

public class Transport {

    private int transportId;

    private String transportType;

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
