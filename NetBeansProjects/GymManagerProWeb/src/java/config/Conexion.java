package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection con;

    String url = "jdbc:mysql://localhost:3306/gym_manager_pro?useSSL=false&serverTimezone=UTC";
    String user = "root";
    String pass = "";

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Conexión Exitosa a gym_manager_pro");
        } catch (Exception e) {
            System.err.println("❌ Error al conectar:");
            e.printStackTrace();
        }
        return con;
    }
}