package sgu.jakarta.demo.jakarta.hello;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sgu.jakarta.demo.jakarta.hello.database.ConnUtils;

@WebServlet(urlPatterns = { "/migration" })
public class MigrateServlet extends HttpServlet {
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
            var sql = """
                    CREATE TABLE USER_ACCOUNT (
                    USER_NAME TEXT NOT NULL PRIMARY KEY,
                    GENDER TEXT NOT NULL CHECK (GENDER IN ('M', 'F')),
                    PASSWORD TEXT NOT NULL
                );

                -- Create table
             
                    """;

            var con = ConnUtils.getSQLiteConnection();
            var stmt = con.createStatement();
            stmt.execute(sql);
            stmt.execute("""
               CREATE TABLE PRODUCT (
                    CODE TEXT NOT NULL PRIMARY KEY,
                    NAME TEXT NOT NULL,
                    PRICE REAL NOT NULL
                );  
            """);
            stmt.execute("INSERT INTO USER_ACCOUNT (USER_NAME, GENDER, PASSWORD) VALUES ('tom', 'M', 'tom001');");
            stmt.execute("INSERT INTO USER_ACCOUNT (USER_NAME, GENDER, PASSWORD) VALUES ('jerry', 'M', 'jerry001');");

            stmt.execute("INSERT INTO PRODUCT (CODE, NAME, PRICE) VALUES ('P001', 'Java Core', 100);");
            stmt.execute("INSERT INTO PRODUCT (CODE, NAME, PRICE) VALUES ('P002', 'C# Core', 90);");
            con.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        //  gui text "ok" ve client
        response.getWriter().println("ok");

	}

}
