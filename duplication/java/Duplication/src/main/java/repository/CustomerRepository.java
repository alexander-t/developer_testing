package repository;

import domain.cms.Customer;
import domain.cms.Gender;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

public class CustomerRepository {

    // Mimic a legacy create method
    public void create(Customer customer) {
        if (customer.getGender() == Gender.UNKNOWN
                || customer.getDateOfBirth() == null) {
            throw new IllegalArgumentException(customer
                    + " not fully initialized");
        }

        LocalDate now = new LocalDate();
        Period period = new Period(customer.getDateOfBirth(),
                now, PeriodType.yearMonthDay());
        if (period.getYears() < 18) {
            throw new IllegalArgumentException(customer
                    + " is underage");
        }

        // Equally scary logic for saving would go here ...

    }

    // Mimic a legacy update method
    public void update(Customer customer) {
        if (customer.getGender() == Gender.UNKNOWN
                || customer.getDateOfBirth() == null) {
            throw new IllegalArgumentException(customer
                    + " not fully initialized");
        }

        LocalDate now = new LocalDate();
        Period period
                = new Period(customer.getDateOfBirth(),
                now, PeriodType.yearMonthDay());
        if (period.getYears() < 18) {
            throw new IllegalArgumentException(customer
                    + " is underage");
        }
    }
}
