package sgu.j2ee.project2.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/migration" })
public class MigrateServlet extends HttpServlet {
    private static final  String dbFile = "/project2.db";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String connectionURL = "jdbc:sqlite:" + dbFile;

            // Tạo kết nối và trả về
            return DriverManager.getConnection(connectionURL);
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
        return connection;

      
    }
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
                try {
                    String sql = "CREATE TABLE IF NOT EXISTS users (\r\n" +
                                 "    id INTEGER PRIMARY KEY AUTOINCREMENT,\r\n" +
                                 "    name TEXT NOT NULL,\r\n" +
                                 "    email TEXT NOT NULL,\r\n" +
                                 "    country TEXT\r\n" +
                                 ");";
                
                    Connection con = getConnection();
                    java.sql.Statement stmt = con.createStatement();
                    stmt.execute(sql);
                
                    // Thêm dữ liệu vào bảng
                    String insertSql = "INSERT INTO users (name, email, country) VALUES " +
                                       "('Nguyen Van A', 'nguyenvana@example.com', 'Vietnam')," +
                                       "('Tran Thi B', 'tranthib@example.com', 'USA')," +
                                       "('Le Van C', 'levanc@example.com', 'Canada')," +
                                       "('Pham Thi D', 'phamthid@example.com', 'Japan')," +
                                       "('Hoang Van E', 'hoangvane@example.com', 'Germany');";
                    
                    stmt.executeUpdate(insertSql);
                
                    con.close();
                
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                
        //  gui text "ok" ve client
        response.getWriter().println("ok");

	}

}
