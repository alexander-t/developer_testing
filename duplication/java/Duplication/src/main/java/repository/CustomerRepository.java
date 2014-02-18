package repository;

import domain.cms.Customer;
import domain.cms.Gender;

import java.util.Calendar;

public class CustomerRepository {

    // Mimic a legacy create method
    public void create(Customer customer) {
        if (customer.getGender() == Gender.UNKNOWN
                || customer.getYearOfBirth() == null) {
            throw new IllegalArgumentException("Incomplete customer");
        }

        if (Calendar.getInstance().get(Calendar.YEAR)
                - customer.getYearOfBirth() < 18) {
            throw new IllegalArgumentException("Underage customer");
        }

        // Equally scary logic for saving would go here...

    }

    // Mimic a legacy update method
    public void update(Customer customer) {
        if (customer.getGender() == Gender.UNKNOWN
                || customer.getYearOfBirth() == null) {
            throw new IllegalArgumentException("Incomplete customer");
        }

        if (Calendar.getInstance().get(Calendar.YEAR)
                - customer.getYearOfBirth() < 18) {
            throw new IllegalArgumentException("Underage customer");
        }
    }
}
