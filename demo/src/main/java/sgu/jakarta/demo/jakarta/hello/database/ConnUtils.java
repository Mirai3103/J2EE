package sgu.jakarta.demo.jakarta.hello.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnUtils {
    
    public static Connection getSQLiteConnection() throws ClassNotFoundException, SQLException {
        String dbFile = "/data.db"; // Đường dẫn đến file SQLite
        return getSQLiteConnection(dbFile);
    }

    public static Connection getSQLiteConnection(String dbFile) throws SQLException, ClassNotFoundException {
        // Load SQLite JDBC Driver
        Class.forName("org.sqlite.JDBC");

        // URL kết nối SQLite
        String connectionURL = "jdbc:sqlite:" + dbFile;

        // Tạo kết nối và trả về
        return DriverManager.getConnection(connectionURL);
    }
}