package by.it_academy.jd2.storage.api;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public abstract class PostgresConnection {
    private static final String url="jdbc:postgresql://localhost:5432/vote";
    private static final String username="postgres";
    private static final String password="77227722";
    private static final String driver="org.postgresql.Driver";
    private static final boolean ssl=false;
    private static final String PATH ="files/connection_properties.txt";
    private static Connection conn=null;

    public static Connection get() {

        try{
            if(conn==null){
                Class.forName(driver);
                Properties props = new Properties();
                props.setProperty("user", username);
                props.setProperty("password", password);
                props.setProperty("ssl", ssl ? "true" : "false");
                conn = DriverManager.getConnection(url,props);

            }
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
