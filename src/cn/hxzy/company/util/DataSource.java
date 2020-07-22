package cn.hxzy.company.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Properties;

public class DataSource {
    private static String url = "";
    private static String username = "";
    private static String password = "";
    private static LinkedList<Connection> pool = new LinkedList<>();

    static {
        try {
            InputStream inputStream = DataSource.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(inputStream);

            String driver = properties.getProperty("jdbc.driverClassName");
            url = properties.getProperty("jdbc.url");
            username = properties.getProperty("jdbc.username");
            password = properties.getProperty("jdbc.password");
            Class.forName(driver);
            for (int i = 0; i < 10; i++) {
                try {
                    pool.add(creatConnection());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private DataSource() {
    }

    public static Connection getConnection() {
        return pool.getFirst();
    }

    public static void closeConnection(Connection connection) {
        pool.addLast(connection);
    }

    private static Connection creatConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

}
