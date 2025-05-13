import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Provides validation functionality for user input during registration and account operations.
 * Validates email addresses, phone numbers, usernames, and passwords.
 */
public class ValidateUser {
    /** OTP generator and validator for phone number verification */
    private final OTP otp = new OTP();

    /**
     * Validates an email address for proper format and uniqueness in the system.
     *
     * @param email The email address to validate
     * @return true if the email is valid and not already registered, false otherwise
     */
    public boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher matcher = emailPattern.matcher(email);
        if (!matcher.matches()) {
            System.out.println("Invalid email format");
            return false;
        }
        if (!Main.userController.isRegisteredEmail(email)) {
            System.out.println("Email is already registered");
            return false;
        }
        return true;
    }

    /**
     * Validates a phone number by checking its availability and verifying via OTP.
     * Generates an OTP and verifies user input against it.
     *
     * @param phoneNumber The phone number to validate
     * @return true if the phone number is valid, available, and OTP verification succeeds
     */
    public boolean isValidPhoneNumber(String phoneNumber) {
        if (!Main.userController.isRegisteredPhoneNumber(phoneNumber))
            return false;
        otp.generate();
        System.out.print("Enter the OTP sent to your phone number without any white spaces between digits: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.nextLine();
        return otp.validateOTP(code);
    }

    /**
     * Checks if a username is available for registration.
     *
     * @param username The username to validate
     * @return true if the username is available, false if already taken
     */
    public boolean isValidUsername(String username) {
        return Main.userController.isRegisteredUsername(username);
    }

    /**
     * Validates a password against security requirements.
     * Password must have at least 8 characters with a mix of uppercase, lowercase,
     * digits, and special characters.
     *
     * @param password The password to validate
     * @return true if the password meets all requirements, false otherwise
     */
    public boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }
}