package domain.cms;

/**
 * A typical representation of a customer found in many systems out there.
 */
public class Customer {
    private final String firstName;
    private final String lastName;

    private Gender gender;
    private Integer yearOfBirth;

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

    public Integer getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(Integer yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}
