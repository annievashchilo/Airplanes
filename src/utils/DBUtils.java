package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DBUtils {

    private static volatile DBUtils instance;
    private static Connection c;
    private final String db_props = "database.properties";
    private String user;
    private String password;
    private String driverName;
    private String db_url;

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
     * @param rq     - template for query
     */
    public static ResultSet executeRequest(String rq) {
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            preparedStatement = c.prepareStatement(rq);

            System.out.println("XXXX REQUEST:" + preparedStatement);
            rs = preparedStatement.executeQuery();
            System.out.println("Query successful -> OK");
        } catch (SQLException e) {
            System.err.println("Failed to make a request");
            System.err.println("SQLException: " + e.getMessage());
        }
        return rs;
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
            System.err.println("Unable to load properties");
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
            System.out.println("Driver loaded successfully -> OK");
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
            System.err.println("Failed to open connection. url " + db_url);
            System.err.println("SQLException: \t" + e.getMessage());
        }
    }
}
