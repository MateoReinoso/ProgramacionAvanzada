package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mateo
 */
public class Conectar {
   static String us = "root";
    static String pass = "";
    static String bd = "proyecto";
    static String url = "jdbc:mysql://localhost:3306/proyecto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public Connection con = null;
    
    public Conectar(){
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, us, pass);
            
            if(con!=null){
                System.out.println("En linea");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public Connection getConexion(){
        return con;
    }
    
    public void desconectar(){
        con = null;
    }
    
    public static void main(String[] args) {
        Conectar c = new Conectar();
        c.getConexion();
    }
}
