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
        if (!validateUser.isValidUsername(username))
            return false;
        if (!validateUser.isValidEmail(email))
            return false;
        if (!validateUser.isValidPassword(password))
            return false;
        return validateUser.isValidPhoneNumber(phoneNumber);
    }
}
