package ModelDAO;

import Config.ConDB;
import Intefaces.PackageCRUD;
import Models.Package;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//using Interfaces
public class PackageDAO implements PackageCRUD{
    
    ConDB cn=new ConDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Package pkg=new Package();

    @Override
    public List list_array() {
        
        // Create Array List with type of Event
        ArrayList<Package>list=new ArrayList<>();
        
        String sql="select * from packages";
        
        try{
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){
                Package p=new Package();
                p.setPackageId(rs.getInt("package_id"));
                p.setPackageName(rs.getString("package_name"));
                p.setPackageCode(rs.getString("package_code"));
                p.setPackageCost(rs.getInt("package_cost"));
                
                list.add(p);
            }
        }catch(Exception e){
            
        }
        
        return list;
    }

    @Override
    public Package list(int id) {
        String sql="select * from packages where package_id="+id;
        
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            
            while(rs.next()){                
                pkg.setPackageId(rs.getInt("package_id"));
                pkg.setPackageName(rs.getString("package_name"));
                pkg.setPackageCode(rs.getString("package_code"));
                pkg.setPackageCost(rs.getInt("package_cost"));
            }
        } catch (Exception e) {
        }
        return pkg;
    }

    @Override
    public boolean add(Package p) {
        String sql = "INSERT INTO packages(package_name, package_code, package_cost) VALUES ('"+p.getPackageName()+"','"+p.getPackageCode()+"','"+p.getPackageCost()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Package p) {
        String sql="update packages set package_name='"+p.getPackageName()+"',package_code='"+p.getPackageCode()+"',package_cost='"+p.getPackageCost()+"'where package_id="+p.getPackageId();
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
        String sql="delete from packages where package_id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
