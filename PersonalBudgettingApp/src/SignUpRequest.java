/**
 * Encapsulates user registration information for creating a new user account.
 * Provides validation of all registration fields before account creation.
 */
public class SignUpRequest {
    /** The requested username for the new account */
    private final String username;

    /** The email address for the new account */
    private final String email;

    /** The password for the new account */
    private final String password;

    /** The phone number for the new account */
    private final String phoneNumber;

    /** Validator used to check the validity of registration fields */
    private ValidateUser validateUser;

    /**
     * Creates a new sign-up request with the provided registration information.
     *
     * @param username The requested username
     * @param email The email address
     * @param password The password
     * @param phoneNumber The phone number
     */
    public SignUpRequest(String username, String email, String password, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the requested username.
     *
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the email address.
     *
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the password.
     *
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the phone number.
     *
     * @return The phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Validates all registration fields for correctness and availability.
     * Checks username availability, email format and availability,
     * password strength, and phone number validation including OTP verification.
     *
     * @return true if all registration fields are valid, false otherwise
     */
    public boolean isValidRequest() {
        if (!validateUser.isValidUsername(username)) {
            System.out.println("Username is already taken");
            return false;
        }
        if (!validateUser.isValidEmail(email))
            return false;
        if (!validateUser.isValidPassword(password)) {
            System.out.println("Password must be at least 8 characters long, contain at least one uppercase letter, one lowercase letter, one digit, and one special character");
            return false;
        }
        return validateUser.isValidPhoneNumber(phoneNumber);
    }
}