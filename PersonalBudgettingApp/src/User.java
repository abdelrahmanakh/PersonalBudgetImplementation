import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a user in the system with personal information, authentication details,
 * account status, and associated financial data.
 */
public class User implements Serializable {
    /**
     * Unique identifier for the user
     */
    private final int UserID;

    /**
     * Tracks the number of consecutive failed login attempts
     */
    private int failedAttempts;

    /**
     * Indicates whether the user account is locked due to security reasons
     */
    private boolean isLocked;

    /**
     * The user's email address used for login and communication
     */
    private final String email;

    /**
     * The user's phone number for verification and communication
     */
    private final String phoneNumber;

    /**
     * The user's chosen username
     */
    private final String username;

    /**
     * The user's password for authentication
     */
    private final String password;

    /**
     * Collection of income sources associated with this user
     */
    private final List<Income> incomeSources;

    /**
     * Collection of expense recipients associated with this user
     */
    private final List<Expense> expenseRecipients;

    /**
     * Collection of budgets created by this user
     */
    private final List<Budget> budgets;

    /**
     * Creates a new user from a sign-up request.
     *
     * @param request The sign-up request containing user information
     * @param ID      The unique identifier to assign to this user
     */
    public User(SignUpRequest request, int ID) {
        username = request.getUsername();
        email = request.getEmail();
        password = request.getPassword();
        phoneNumber = request.getPhoneNumber();
        failedAttempts = 0;
        UserID = ID;
        isLocked = false;
        this.incomeSources = new ArrayList<>();
        this.expenseRecipients = new ArrayList<>();
        this.budgets = new ArrayList<>();
    }

    /**
     * Gets the username of this user.
     *
     * @return The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the email address of this user.
     *
     * @return The email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the password of this user.
     *
     * @return The password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the phone number of this user.
     *
     * @return The phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the unique identifier of this user.
     *
     * @return The user ID
     */
    public int getUserID() {
        return UserID;
    }

    /**
     * Gets the number of consecutive failed login attempts.
     *
     * @return The number of failed attempts
     */
    public int getFailedAttempts() {
        return failedAttempts;
    }

    /**
     * Increments the counter for failed login attempts.
     * Used for security monitoring and account locking.
     */
    public void incrementFailedAttempts() {
        failedAttempts++;
    }

    /**
     * Resets the failed attempts counter to zero.
     * Typically called after a successful login.
     */
    public void resetFailedAttempts() {
        failedAttempts = 0;
    }

    /**
     * Checks if the user account is currently locked.
     *
     * @return true if the account is locked, false otherwise
     */
    public boolean isLocked() {
        return isLocked;
    }

    /**
     * Locks the user account, preventing login attempts.
     * Typically called after multiple failed login attempts or security concerns.
     */
    public void lockAccount() {
        isLocked = true;
    }

    /**
     * Unlocks a previously locked user account, allowing login attempts.
     */
    public void unlockAccount() {
        isLocked = false;
    }

    /**
     * Gets the list of income sources associated with the user.
     *
     * @return The list of income sources
     */
    public List<Income> getIncomeSources() {
        return incomeSources;
    }

    /**
     * Gets the list of expense recipients associated with the user.
     * @return the list of expense recipients
     */
    public List<Expense> getExpenseRecipients() {
        return expenseRecipients;
    }

    /**
     * Gets the list of budgets associated with the user.
     *
     * @return The list of budgets
     */
    public List<Budget> getBudgets() {
        return budgets;
    }

}