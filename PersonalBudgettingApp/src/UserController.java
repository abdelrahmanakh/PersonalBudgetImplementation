import java.util.ArrayList;
import java.util.Objects;

/**
 * Controls user-related operations including creation, validation, authentication, and account management.
 * Maintains a collection of all registered users in the system.
 */
public class UserController {
    /** List of all registered users in the system */
    public ArrayList<User> users;

    /**
     * Creates a new user from a sign-up request and adds them to the system.
     *
     * @param request The sign-up request containing user information
     */
    public void createUser(SignUpRequest request) {
        User user = new User(request, users.size());
        users.add(user);
    }

    /**
     * Checks if a username is not already registered in the system.
     *
     * @param username The username to check
     * @return true if the username is available, false if already taken
     */
    public boolean isRegisteredUsername(String username) {
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username))
                return false;
        }
        return true;
    }

    /**
     * Checks if an email address is not already registered in the system.
     *
     * @param email The email address to check
     * @return true if the email is available, false if already taken
     */
    public boolean isRegisteredEmail(String email) {
        for (User user : users) {
            if (Objects.equals(user.getEmail(), email))
                return false;
        }
        return true;
    }

    /**
     * Checks if a phone number is not already registered in the system.
     *
     * @param phoneNumber The phone number to check
     * @return true if the phone number is available, false if already taken
     */
    public boolean isRegisteredPhoneNumber(String phoneNumber) {
        for (User user : users) {
            if (Objects.equals(user.getPhoneNumber(), phoneNumber))
                return false;
        }
        return true;
    }

    /**
     * Removes a user from the system.
     *
     * @param user The user to delete
     */
    public void deleteUser(User user) {
        users.remove(user.getUserID());
    }

    /**
     * Increments the number of failed login attempts for a user.
     *
     * @param user The user whose failed attempts count should be incremented
     */
    public void incrementFailedAttempts(User user) {
        users.get(user.getUserID()).incrementFailedAttempts();
    }

    /**
     * Resets the number of failed login attempts for a user.
     *
     * @param user The user whose failed attempts count should be reset
     */
    public void resetFailedAttempts(User user) {
        users.get(user.getUserID()).resetFailedAttempts();
    }

    /**
     * Locks a user's account, preventing them from logging in.
     *
     * @param user The user whose account should be locked
     */
    public void lockAccount(User user) {
        users.get(user.getUserID()).lockAccount();
    }

    /**
     * Unlocks a previously locked user account.
     *
     * @param user The user whose account should be recovered/unlocked
     */
    public void recoverAccount(User user) {
        users.get(user.getUserID()).unlockAccount();
    }

    /**
     * Authenticates a user based on email and password.
     *
     * @param email The email address of the user attempting to login
     * @param password The password provided for authentication
     * @return The user ID if authentication is successful, -1 otherwise
     */
    public int login(String email, String password) {
        for (User user : users) {
            if (Objects.equals(user.getEmail(), email) && Objects.equals(user.getPassword(), password))
                return user.getUserID();
        }
        return -1;
    }
}