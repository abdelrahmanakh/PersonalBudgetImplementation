import java.security.SecureRandom;
import java.util.Objects;

/**
 * Provides One-Time Password (OTP) generation and validation functionality.
 * Used for verifying user phone numbers and secure operations.
 */
public class OTP {
    /** The generated OTP code */
    private String code;

    /**
     * Generates a new 6-digit OTP using secure random number generation.
     * The generated code is stored for later validation.
     */
    public void generate() {
        StringBuilder otp = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 6; ++i)
            otp.append(secureRandom.nextInt(10));
        code = otp.toString();
    }

    /**
     * Validates an OTP input against the previously generated code.
     * Prompts the user to enter the OTP sent to their phone number.
     *
     * @param otpL The OTP entered by the user
     * @return true if the entered OTP matches the generated code, false otherwise
     */
    public boolean validateOTP(String otpL) {
        System.out.print("Enter the OTP sent to your phone number without any white spaces between digits: ");
        if (!Objects.equals(otpL, code)) {
            System.out.println("Invalid OTP");
            return false;
        }
        return true;
    }
}