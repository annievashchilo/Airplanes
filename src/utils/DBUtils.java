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

    private static volatile DBUtils instance;

    private String user;
    private String password;
    private String driverName;
    private String db_url;

    private static Connection c;


    /**
     * create only 1 instance of DBUtils, to open only 1 connection to database
     * lazy initialization
     * high performance
     *
     * @return localInstance
     */
    public static DBUtils getInstance() {
        DBUtils localInstance = instance;
        if (localInstance == null) {
            synchronized (DBUtils.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DBUtils();
                    instance.openDBConnection();
                }
            }
        }
        return localInstance;
    }

    /**
     * make a request to database
     *
     * @param rq     - template for request
     * @param values - variable number of parameters to request template
     */
    public static void makeRequest(String rq, String... values) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = c.prepareStatement(rq);
            preparedStatement.setString(Integer.parseInt(values[0]), values[1]);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to make a request");
            System.err.println("SQLException: " + e.getMessage());
        }
    }

    /**
     * Read properties from file
     */
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
