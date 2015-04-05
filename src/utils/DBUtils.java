package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Anny on 05.04.15.
 */
public class DBUtils {

    private final String db_props = "database.properties";

    private String user;
    private String password;
    private String driverName;
    private String db_url;

    private Connection c;

    public static void makeRequest(PreparedStatement rq) {

        try {

            rq.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void readProperties() {
        Properties props = new Properties();

        try {
            FileInputStream file_in = new FileInputStream(db_props);
            props.load(file_in);
            file_in.close();
        } catch (IOException e) {
            System.out.println("Unable to load properties");
            return;
        }

        driverName = props.getProperty("driver");
        db_url = props.getProperty("db_url");
        user = props.getProperty("user");
        password = props.getProperty("password");
    }

    private void loadDriver() {
        try {
            Class.forName(driverName);
            System.out.println("OK");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found");
        }
    }

    private void openDBConnection() {
        readProperties();
        loadDriver();
        try {
            c = DriverManager.getConnection(db_url, user, password);
            System.out.println("Connection to database opened");
        } catch (SQLException e) {
            System.err.println("Failed to open connection");
            System.err.println("SQLException: \t" + e.getMessage());
        }
    }
}
