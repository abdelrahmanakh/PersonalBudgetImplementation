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
        System.out.println("Hint! " + code);
    }
    public String getCode() {
        return code;
    }
    /**
     * Validates an OTP input against the previously generated code.
     * Prompts the user to enter the OTP sent to their phone number.
     *
     * @param otpL The OTP entered by the user
     * @return true if the entered OTP matches the generated code, false otherwise
     */
    public boolean validateOTP(String otpL) {
        if (!Objects.equals(otpL, code)) {
            System.out.println("Invalid OTP");
            return false;
        }
        return true;
    }
}