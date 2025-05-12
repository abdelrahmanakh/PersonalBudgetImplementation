import java.time.LocalDate;

/**
 * Represents a financial entry with an id, amount, title, recurrence status, and date.
 */
public class FinancialEntry {
    private final int id;
    private float amount;
    private String title;
    private boolean isRecurring;
    private final LocalDate date;

    /**
     * Constructs a new FinancialEntry.
     * @param id           The unique identifier for this financial entry.
     * @param amount       The amount associated with this entry.
     * @param title        The title or description of the entry.
     * @param isRecurring  The recurrence status of the entry (true if recurring, false otherwise).
     */
    public FinancialEntry(int id, float amount, String title, boolean isRecurring) {
        this.id = id;
        this.amount = amount;
        this.title = title;
        this.isRecurring = isRecurring;
        this.date = LocalDate.now();
    }

    // === Getters and Setters ===
    /**
     * @return The unique ID of the financial entry.
     */
    public int getId() {
        return id;
    }

    /**
     * @return The amount of the financial entry.
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Updates the amount of the financial entry.
     * @param amount The new amount to set.
     */
    public void updateAmount(float amount) {
        this.amount = amount;
    }

    /**
     * @return The title or description of the financial entry.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Changes the title of the financial entry.
     * @param title The new title to set.
     */
    public void changeTitle(String title) {
        this.title = title;
    }

    /**
     * @return True if recurring, false otherwise.
     */
    public boolean isRecurring() {
        return isRecurring;
    }

    /**
     * Marks the financial entry as recurring.
     */
    public void makeRecurring() {
        this.isRecurring = true;
    }

    /**
     * Cancels the recurrence of the financial entry.
     */
    public void cancelRecurring() {
        this.isRecurring = false;
    }

    /**
     * @return The date the financial entry was created.
     */
    public LocalDate getDate() {
        return date;
    }
}
