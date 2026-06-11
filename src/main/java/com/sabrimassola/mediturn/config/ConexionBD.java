package com.sabrimassola.mediturn.config;

import java.sql.*;

public class ConexionBD {
    private static final String url=System.getenv("DB_URL");
    private static final String user=System.getenv("DB_USER");
    private static final String password=System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

}
