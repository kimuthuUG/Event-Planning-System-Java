package Intefaces;

import Models.Event;
import java.util.List;

//using Interfaces
public interface EventCRUD {
    public List list_array();
    public Event list(int id);
    public boolean add(Event ev);
    public boolean edit(Event ev);
    public boolean delete(int id);
}
