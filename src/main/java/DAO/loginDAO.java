package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class loginDAO {
    Connection conn;
    public loginDAO() {
        try {
            conn = DriverManager.getConnection("/register");
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
