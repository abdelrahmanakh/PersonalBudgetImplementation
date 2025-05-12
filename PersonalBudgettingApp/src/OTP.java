import java.security.SecureRandom;
import java.util.Objects;

public class OTP {
    String code;

    void generate() {
        StringBuilder otp = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 6; ++i)
            otp.append(secureRandom.nextInt(10));
        code = otp.toString();
    }

    boolean validateOTP(String otpL) {
        System.out.print("Enter the OTP sent to your phone number without any white spaces between digits: ");
        if (!Objects.equals(otpL, code)) {
            System.out.println("Invalid OTP");
            return false;
        }
        return true;
    }
}
