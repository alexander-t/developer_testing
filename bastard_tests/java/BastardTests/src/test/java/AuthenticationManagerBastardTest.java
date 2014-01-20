import auth.AuthenticationManager;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import static org.junit.Assert.assertTrue;

/**
 * This fast test creates a users table and tests a supposed
 */
public class AuthenticationManagerBastardTest {

    private static Connection conn;

    @BeforeClass
    public static void setUpOnce() throws Exception {
        Class.forName("org.hsqldb.jdbc.JDBCDriver");
        conn = DriverManager
                .getConnection("jdbc:hsqldb:mem:db",
                        "SA", "");
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE users(" +
                "id BIGINT IDENTITY, " +
                "name VARCHAR(255), " +
                "password_hash VARCHAR(255))");
        stmt.close();
    }

    @Test
    public void successfulAuthentication() throws Exception {
        conn.createStatement().execute(
                "INSERT INTO users " +
                "(id, name, password_hash) " +
                "VALUES(NULL, 'joe', '%Gjk!44R/P')");

        assertTrue(new AuthenticationManager(conn)
                .authenticate("joe", "secret"));
    }
}
