package conexao_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
    private static String url = "";
    private static String password = "";
    private static String user = "";
    private static Connection connection = null;

    static {
        conectar();
    }
    public SingleConnection() {
        conectar();
    }

    private static void conectar(){
        try {
            if (connection == null){
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url,user,password);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }

}
