package ModelDAO;

import Config.ConDB;
import Intefaces.EventCRUD;
import Models.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//using Interfaces
public class EventDAO implements EventCRUD{
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Event cat=new Event();

    @Override
    public List list_array() {
        // Create Array List with type of Event
        ArrayList<Event>list=new ArrayList<>();
        
        String sql="select * from events";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Event ec=new Event();
                ec.setEventId(rs.getInt("event_id"));
                ec.setEventName(rs.getString("event_name"));
                ec.setVenue(rs.getString("venue"));
                ec.setEventDate(rs.getDate("event_date"));
                ec.setStatus(rs.getString("status"));
                ec.setCategoryId(rs.getInt("category_id"));
                ec.setDescription(rs.getString("description"));
                
                list.add(ec);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Event list(int id) {
        String sql="select * from events where event_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                cat.setEventId(rs.getInt("event_id"));;
                cat.setEventName(rs.getString("event_name"));
                cat.setVenue(rs.getString("venue"));
                cat.setEventDate(rs.getDate("event_date"));
                cat.setStatus(rs.getString("status"));
                cat.setCategoryId(rs.getInt("category_id"));
                cat.setDescription(rs.getString("description"));
            }
        } catch (Exception e) {
        }
        return cat;
    }

    @Override
    public boolean add(Event ec) {
        String sql = "INSERT INTO events(event_name, venue, event_date, status, category_id, description) VALUES ('"+ec.getEventName()+"','"+ec.getVenue()+"','"+ec.getEventDate()+"','"+ec.getStatus()+"','"+ec.getCategoryId()+"','"+ec.getDescription()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Event ec) {
        String sql="update events set event_name='"+ec.getEventName()+"',venue='"+ec.getVenue()+"',event_date='"+ec.getEventDate()+"',status='"+ec.getStatus()+"',category_id='"+ec.getCategoryId()+"',description='"+ec.getDescription()+"' where event_id="+ec.getEventId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql="delete from events where event_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }    

}
