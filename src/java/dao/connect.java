package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class connect {

    Connection con;

    public connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Shop", "sa", "123456");
        } catch (Exception e) {
        }
    }
}
