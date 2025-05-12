/**
 * Represents an expense entry in the financial system, extending the FinancialEntry class.
 * Contains details about the expense id, recipient, amount, title, and whether it's recurring.
 */
public class Expense extends FinancialEntry{
    private String recipient;

    /**
     * Constructs a new expense object with the given details.
     * @param id The unique identifier for this expense entry.
     * @param amount The amount of the expense.
     * @param title The title or description of the expense.
     * @param recipient The recipient of the expense.
     * @param isRecurring Indicates whether the expense is recurring.
     */
    public Expense(int id, float amount, String title, String recipient, boolean isRecurring) {
        super(id, amount, title, isRecurring);
        this.recipient = recipient;
    }

    // === Getters and Setters ===
    /**
     * @return The recipient of the expense.
     */
    public String getRecipient() {
        return recipient;
    }

    /**
     * Updates the recipient of the expense.
     * @param recipient The new recipient of the expense.
     */
    public void updateRecipient(String recipient) {
        this.recipient = recipient;
    }
}
