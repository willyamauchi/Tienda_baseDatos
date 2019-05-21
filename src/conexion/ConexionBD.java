
package conexion;

import java.sql.*;

public class ConexionBD {

    private static final String HOST;
    private static final String PORT;
    private static final String DATABASE;
    private static final String USER;
    private static final String PASSWORD;
    private static final String URL_PARAMETRO;
    private static final String URL;

    static {
        HOST = "localhost";
        PORT = "3306";
        DATABASE = "tienda1";
        USER = "root";

        PASSWORD = "";
        URL_PARAMETRO = "?serverTimezone=UTC";
        URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + URL_PARAMETRO;
        cargarDriver();
        
    }

    public static Connection conectar() {
       Connection conexion=null;
        try{
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Base de datos conectados");
        }catch(SQLException ex){
            System.out.println("No se puede conectar base de datos");
            ex.printStackTrace();
            System.exit(1);
        }
      return conexion;
    }
    
    private static void cargarDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("No se ha podido cargar el Driver JDB_Mysql");
            System.exit(1);
        }
        
    }

}
