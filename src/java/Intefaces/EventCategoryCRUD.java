package Intefaces;

import Models.EventCategory;
import java.util.List;

//using Interfaces
public interface EventCategoryCRUD {
    public List list_array();
    public EventCategory list(int id);
    public boolean add(EventCategory ec);
    public boolean edit(EventCategory ec);
    public boolean delete(int id);
}
