package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    private String jdbcURL = "jdbc:mysql://localhost:3306/control_furama";
    private String username = "root";
    private String password = "123";
    private Connection connection;

    public Connection getConnectionJavaToMySQL(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcURL,username,password);
            return connection;
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
