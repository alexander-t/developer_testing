package domain.cms;

import org.joda.time.LocalDate;

/**
 * A typical representation of a customer found in many systems out there.
 */
public class Customer {
    private final String firstName;
    private final String lastName;

    private Gender gender;
    private LocalDate dateOfBirth;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
