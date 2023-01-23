package pkg5erronka;

import java.sql.Connection;
import java.sql.DriverManager;

public class mySQLkonexioa {
    public static void main(String[] args) {

        try {

            
            String url = "jdbc:mysql://localhost:3306/salmentak";
            String username = "root";
            String password = "lanchajim";
        
            Connection con = DriverManager.getConnection(url, username, password);
        
            con.close();

        } catch (Exception e) {
            
        }
    

    }
    
}
