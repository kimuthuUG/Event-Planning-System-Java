package ModelDAO;

import Config.ConDB;
import Intefaces.EventCategoryCRUD;
import Models.EventCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//using Interfaces
public class EventCategoryDAO implements EventCategoryCRUD{
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    EventCategory cat=new EventCategory();

    @Override
    public List list_array() {
        // Create Array List with type of Event
        ArrayList<EventCategory>list=new ArrayList<>();
        
        String sql="select * from event_categories";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                EventCategory ec=new EventCategory();
                ec.setCategoryId(rs.getInt("category_id"));
                ec.setCategoryName(rs.getString("category_name"));
                ec.setCategoryDesc(rs.getString("category_desc"));
                
                list.add(ec);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public EventCategory list(int id) {
        String sql="select * from event_categories where category_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                cat.setCategoryId(rs.getInt("category_id"));
                cat.setCategoryName(rs.getString("category_name"));
                cat.setCategoryDesc(rs.getString("category_desc"));
            }
        } catch (Exception e) {
        }
        return cat;
    }

    @Override
    public boolean add(EventCategory ec) {
        String sql = "INSERT INTO event_categories(category_name, category_desc) VALUES ('"+ec.getCategoryName()+"','"+ec.getCategoryDesc()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(EventCategory ec) {
        String sql="update event_categories set category_name='"+ec.getCategoryName()+"',category_desc='"+ec.getCategoryDesc()+"' where category_id="+ec.getCategoryId();
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
        String sql="delete from event_categories where category_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }    

}
