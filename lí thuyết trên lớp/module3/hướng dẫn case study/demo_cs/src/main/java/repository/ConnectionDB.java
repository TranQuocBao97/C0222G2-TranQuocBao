package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/case_study_3_c03";
    private String username = "root";
    private String password = "123123";
    private Connection connection;

    public ConnectionDB() {
        //Cách 1
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
//        } catch (ClassNotFoundException | SQLException e) {
//            e.printStackTrace();
//        }
    }

    public Connection getConnectionJavaToDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(jdbcUrl, username, password);
            return connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
}
