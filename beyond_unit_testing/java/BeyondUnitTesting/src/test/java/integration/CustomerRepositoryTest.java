package integration;

import domain.Customer;
import domain.SecurityCredentials;
import org.exparity.hamcrest.date.DateMatchers;
import repository.CustomerRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.sql.DataSource;

import java.security.MessageDigest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@ContextConfiguration(classes = {TestContextConfiguration.class})
public class CustomerRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private CustomerRepository customerRepository;

    /* This isn't part of the actual test. It simulates a disk-based database by setting
     * up the necessary tables.
     */
    @BeforeClass
    public static void setUpOnce() {
        DataSource ds = new TestContextConfiguration().dataSource();
        JdbcTemplate template = new JdbcTemplate(ds);
        template.execute("create table customer (id INTEGER IDENTITY, first_name VARCHAR(255), last_name VARCHAR(255), email VARCHAR(255), shipping_address VARCHAR(255), date_created DATE)");
    }

    @Before
    public void setUp() {
    }

    @Test
    public void createCustomer_newCustomersAreStoredAndGetSecurityCredentials() {
        final String firstName = "John";
        final String lastName = "Smith";
        final String emailAddress = "john@smith.com";
        final String shippingAddress = "100 Main St., Phoenix AZ 85236";

        long newCustomerId = customerRepository.createCustomer(firstName, lastName,
                emailAddress, shippingAddress);

        Customer newCustomer = customerRepository.getCustomerById(newCustomerId);
        assertEquals(firstName, newCustomer.getFirstName());
        assertEquals(lastName, newCustomer.getLastName());
        assertEquals(shippingAddress, newCustomer.getShippingAddress());
        assertThat(newCustomer.getDateCreated(), DateMatchers.isToday());

        SecurityCredentials credentials = newCustomer.getSecurityCredentials();
        String sha1HashOfSecretAndName = "a45c09720466a51a8bfd5c4a4c7d04a1a1155deb";
        assertEquals(emailAddress, credentials.getLoginName());
        assertEquals(sha1HashOfSecretAndName, credentials.getPassword());
    }

    @Test
    public void showsThatTheTestsAreTrulyRunInTheirOwnTransactions() {
        assertEquals(0, jdbcTemplate.queryForObject("SELECT COUNT(*) FROM CUSTOMER", Integer.class).intValue());
    }
}
