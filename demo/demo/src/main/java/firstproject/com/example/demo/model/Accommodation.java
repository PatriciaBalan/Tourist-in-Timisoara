package firstproject.com.example.demo.model;

public class Accommodation {

    private int accommodationId;

    private String accommodationName;

    private String accommodationDetail;

    public Accommodation() {

    }

    public Accommodation(int accommodationId, String accommodationName, String accommodationDetail){
        this.accommodationId=accommodationId;
        this.accommodationName=accommodationName;
        this.accommodationDetail=accommodationDetail;
    }

    public int getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(int accommodationId){
        this.accommodationId=accommodationId;
    }

    public String getAccommodationName() {
        return  accommodationName;
    }

    public void setAccommodationName(String accommodationName) {
        this.accommodationName=accommodationName;
    }

    public String getAccommodationDetails(){
        return accommodationDetail;
    }

    public void setAccommodationDetails(String accommodationDetail) {
        this.accommodationDetail=accommodationDetail;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
                "accommodationId" + accommodationId +
                "accommodationName" + accommodationName + '\'' +
                "accommodationDetail" + accommodationDetail + '\'' +
                "}";
    }
}
