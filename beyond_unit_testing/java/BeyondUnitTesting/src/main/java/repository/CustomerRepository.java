package repository;

import domain.Customer;
import domain.SecurityCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
public class CustomerRepository extends JdbcDaoSupport {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    public long createCustomer(String firstName, String lastName, String email, String shippingAddress) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        getJdbcTemplate().update(conn -> {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO customer (first_name, last_name, email, shipping_address, date_created) VALUES(?, ?, ?, ?, NOW())", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, shippingAddress);
            return ps;
        }, keyHolder);
        return keyHolder.getKey().longValue();
    }

    public Customer getCustomerById(long id) {
        return getJdbcTemplate().queryForObject("SELECT first_name, last_name, email, shipping_address, date_created FROM CUSTOMER", new RowMapper<Customer>() {
            @Override
            public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                Customer customer = new Customer(firstName, lastName,
                        rs.getString("shipping_address"), rs.getDate("date_created"));

                // Cheating a little here... This should be in its own table, not generated
                SecurityCredentials credentials = new SecurityCredentials();
                credentials.setLoginName(rs.getString("email"));
                credentials.setPassword(org.apache.commons.codec.digest.DigestUtils.sha1Hex("SECRETSAUCE" + firstName + lastName));
                customer.setSecurityCredentials(credentials);
                return customer;
            }
        });
    }
}
