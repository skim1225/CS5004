package problem1;

import java.util.Objects;

/**
 * User is a simple class that represents a user as their first name, last name, phone number,
 * email, and credentials as a Credential object.
 */
public class User {


    private final Integer PHONE_NUMBER_LENGTH = 10;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private Credentials credentialPair;

    /**
     * Constructor creating a new User object with provided first naem, last name,
     * email, phone number, and credentials.
     * @param firstName - first name as a String
     * @param lastName - last name as a String
     * @param phoneNumber - phone number as a String
     * @param email - email as a String
     * @param credentialPair - credentials as a Credential object
     */
    public User(String firstName, String lastName, String phoneNumber, String email, Credentials credentialPair) {
        if (phoneNumber.length() == PHONE_NUMBER_LENGTH) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.credentialPair = credentialPair;
        } else {
            System.out.println("Invalid phone number.");
        }
    }

    /**
     * Returns the first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the phone number
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Returns the email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the credentials
     * @return the credentials
     */
    public Credentials getCredentialPair() {
        return credentialPair;
    }

    /**
     * Sets first name to the given first name
     * @param firstName The first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets last name to the given first name
     * @param lastName The first name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets phone number to the given phone number
     * @param phoneNumber The phone number to be set
     */
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == PHONE_NUMBER_LENGTH) {
            this.phoneNumber = phoneNumber;
        } else {
            System.out.println("Invalid phone number");
        }
    }

    /**
     * Sets email address to the given email
     * @param email The email address to be set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets credentialpair to the given credentials
     * @param credentialPair The credentials to be set
     */
    public void setCredentialPair(Credentials credentialPair) {
        this.credentialPair = credentialPair;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(PHONE_NUMBER_LENGTH, user.PHONE_NUMBER_LENGTH)
            && Objects.equals(firstName, user.firstName) && Objects.equals(lastName,
            user.lastName) && Objects.equals(phoneNumber, user.phoneNumber)
            && Objects.equals(email, user.email) && Objects.equals(credentialPair,
            user.credentialPair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber, email,
            credentialPair);
    }
}
