package auth;

import java.sql.Connection;

public class AuthenticationManager {

    private Connection connection;

    public AuthenticationManager(Connection connection) {
        this.connection = connection;
    }

    public boolean authenticate(String username, String plaintextPassword) {
        return true;
    }
}
