import java.util.ArrayList;
import java.util.Objects;

public class UserController {
    ArrayList<User> users;

    void createUser(SignUpRequest request) {
        User user = new User(request, users.size());
        users.add(user);
    }

    boolean isRegisteredUsername(String username) {
        for (User user : users) {
            if (Objects.equals(user.username, username))
                return false;
        }
        return true;
    }

    boolean isRegisteredEmail(String email) {
        for (User user : users) {
            if (Objects.equals(user.email, email))
                return false;
        }
        return true;
    }

    boolean isRegisteredPhoneNumber(String phoneNumber) {
        for (User user : users) {
            if (Objects.equals(user.phoneNumber, phoneNumber))
                return false;
        }
        return true;
    }

    void deleteUser(User user) {
        users.remove(user.UserID);
    }

    void incrementFailedAttempts(User user) {
        ++users.get(user.UserID).failedAttempts;
    }

    void resetFailedAttempts(User user) {
        users.get(user.UserID).failedAttempts = 0;
    }

    void lockAccount(User user) {
        users.get(user.UserID).isLocked = true;
    }

    void recoverAccount(User user) {
        users.get(user.UserID).isLocked = false;
    }

    int login(String email, String password) {
        for (User user : users) {
            if (Objects.equals(user.email, email) && Objects.equals(user.password, password))
                return user.UserID;
        }
        return -1;
    }
}
