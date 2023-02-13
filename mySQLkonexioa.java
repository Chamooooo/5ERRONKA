package pkg5erronka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class mySQLkonexioa {    

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static Connection conn;

   public mySQLkonexioa() {
      conn = null;
   }

   public static Connection getConnection() {
      if (conn == null) {
         try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection("jdbc:mysql://192.168.100.4:3306/salmentak", "ERRONKAML", "izarraitz2023");
            System.out.println("ONDO KONEKTATU DA");
         } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
             System.out.println("EZIN IZAN DA KONEKTATU");
         }
      }
      return conn;
   }

   public void closeConnection() {
      if (conn != null) {
         try {
            conn.close();
            conn = null;
            System.out.println("ONDO DESKONEKTATU DA");
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public PreparedStatement prepareStatement() {
        return null;
    }


}
