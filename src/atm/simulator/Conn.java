package atm.simulator;

import java.sql.*;

public class Conn {
    
    Connection c;
    Statement s;
    public Conn(){
        try {
            c = DriverManager.getConnection("jdbc:mysql:///atmsimulator","root","r@2194#k");
            s = c.createStatement();
        
        } catch (Exception e){
           System.out.println(e);
        }
    }
}
