public class SignUpRequest {
    String username, email, password, phoneNumber;
    ValidateUser validateUser;

    SignUpRequest(String username, String email, String password, String phoneNumber) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    boolean isValidRequest() {
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
