import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidateUser {
    OTP otp;

    boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher matcher = emailPattern.matcher(email);
        if (!matcher.matches()) {
            System.out.println("Invalid email format");
            return false;
        }
        if (!Main.userController.isRegisteredUsername(email)) {
            System.out.println("Email is already registered");
            return false;
        }
        return true;
    }

    boolean isValidPhoneNumber(String phoneNumber) {
        if (!Main.userController.isRegisteredPhoneNumber(phoneNumber))
            return false;
        otp.generate();
        String code = "";
        return otp.validateOTP(code);
    }

    boolean isValidUsername(String username) {
        return Main.userController.isRegisteredUsername(username);
    }

    boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=]).{8,}$";
        Pattern passwordPattern = Pattern.compile(passwordRegex);
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }
}
