package org.example.connecting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connecting {
    private static final String URL = "jdbc:mysql://localhost:3306/newDB?user=root";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "кщще";

    public Statement connect() throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Statement statement;
        {
            Connection s = DriverManager.getConnection(URL, username, password);
            statement = s.createStatement();
            if (s != null) {
                System.out.println("Server connect");
            }
        }
        return statement;
    }
}
