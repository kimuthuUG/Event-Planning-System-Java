package Models;

public class EventCategory {
    
    // Define Variables
    int category_id;
    String category_name;
    String category_desc;

    // Call default constructor
    public EventCategory() {
    }

    public EventCategory(String category_name, String category_desc) {
        this.category_name = category_name;
        this.category_desc = category_desc;
    }

    // Create Getters and Setters to access private variables
    public int getCategoryId() {
        return category_id;
    }

    public void setCategoryId(int category_id) {
        this.category_id = category_id;
    }

    public String getCategoryName() {
        return category_name;
    }

    public void setCategoryName(String category_name) {
        this.category_name = category_name;
    }

    public String getCategoryDesc() {
        return category_desc;
    }

    public void setCategoryDesc(String category_desc) {
        this.category_desc = category_desc;
    }
       
}
