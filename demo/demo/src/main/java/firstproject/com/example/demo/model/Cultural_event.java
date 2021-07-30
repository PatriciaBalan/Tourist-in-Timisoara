package firstproject.com.example.demo.model;

import java.util.Date;

public class Cultural_event {

    private int eventId;

    private String eventName;

    private String eventDetail;

    private Date eventDate;

    public Cultural_event() {
    }

    public Cultural_event(int eventId, String eventName, String eventDetail, Date eventDate) {
        this.eventId=eventId;
        this.eventName=eventName;
        this.eventDetail=eventDetail;
        this.eventDate=eventDate;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    @Override
    public String toString() {
        return "Cultural_event{" +
                "eventId=" + eventId +
                ", eventName='" + eventName + '\'' +
                ", eventDetail='" + eventDetail + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}
