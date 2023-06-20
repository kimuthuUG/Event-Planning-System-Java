
package Config;

import java.sql.*;

public class ConDB {
    Connection con; //Create Ref Variabale
    public ConDB(){
        //Cheack errorss
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Load the Driver
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/event_planning","root","");            
        } catch (Exception e) {
            System.err.println("Error"+e); //Print the error massage
        }
    }
    public Connection getConnection(){
        return con;
    }
}
