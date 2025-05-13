import java.io.Serializable;

/**
 * Represents an income entry in the financial system, extending the FinancialEntry class.
 * Contains details about the income id, source, amount, title, and whether it's recurring.
 */
public class Income extends FinancialEntry implements Serializable {
    private String source;

    /**
     * Constructs a new Income object with the given details.
     * @param id The unique identifier for this income entry.
     * @param amount The amount of the income.
     * @param title The title or description of the income.
     * @param source The source of the income.
     * @param isRecurring Indicates whether the income is recurring.
     */
    public Income(int id, float amount, String title, String source, boolean isRecurring) {
        super(id, amount, title, isRecurring);
        this.source = source;
    }

    // === Getters and Setters ===
    /**
     * @return The source of the income.
     */
    public String getSource() {
        return source;
    }

    /**
     * Updates the source of the income.
     * @param source The new source of the income.
     */
    public void updateSource(String source) {
        this.source = source;
    }
}
