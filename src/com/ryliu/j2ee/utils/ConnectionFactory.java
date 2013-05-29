package com.ryliu.j2ee.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The factory that generate JDBC connection.
 */
public class ConnectionFactory {

    private static final String CLASS = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://10.12.8.28:3306/je1124061?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "je1124061";
    private static final String PASSWORD = "283245";

    /**
     * The singleton instance.
     */
    private static ConnectionFactory instance = null;

    private ConnectionFactory() {
        try {
            Class.forName(CLASS);
        } catch (ClassNotFoundException e) {
            // Ignore
        }
    }

    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
