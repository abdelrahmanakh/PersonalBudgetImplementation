import java.util.ArrayList;
import java.util.List;

public class User {
    int UserID, failedAttempts;
    boolean isLocked;
    String email, phoneNumber, username, password;
    private final List<Income> incomeSources;
    private final List<Budget> budgets;
    User(SignUpRequest request, int ID) {
        username = request.username;
        email = request.email;
        password = request.password;
        phoneNumber = request.phoneNumber;
        failedAttempts = 0;
        UserID = ID;
        isLocked = false;
        this.incomeSources = new ArrayList<>();
        this.budgets = new ArrayList<>();
    }

    /**
     * @return the list of income sources associated with the user
     */
    public List<Income> getIncomeSources() {
        return incomeSources;
    }

    /**
     * @return the list of budgets associated with the user
     */
    public List<Budget> getBudgets() {
        return budgets;
    }

}
