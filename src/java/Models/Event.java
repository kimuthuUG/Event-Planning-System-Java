package Models;

import java.sql.Date;

public class Event {
    
    // Define VAriables
    int event_id;
    String event_name;
    String venue;
    Date event_date;
    String status;
    int category_id;
    String description;

    // Call default constructor
    public Event() {
    }

    public Event(String event_name, String venue, Date event_date, String status, int category_id, String description) {
        this.event_name = event_name;
        this.venue = venue;
        this.event_date = event_date;
        this.status = status;
        this.category_id = category_id;
        this.description = description;
    }

    // Create Getters and Setters to access private variables
    public int getEventId() {
        return event_id;
    }

    public void setEventId(int event_id) {
        this.event_id = event_id;
    }

    public String getEventName() {
        return event_name;
    }

    public void setEventName(String event_name) {
        this.event_name = event_name;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Date getEventDate() {
        return event_date;
    }

    public void setEventDate(Date event_date) {
        this.event_date = event_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int category_id) {
        this.category_id = category_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
       
    
}
