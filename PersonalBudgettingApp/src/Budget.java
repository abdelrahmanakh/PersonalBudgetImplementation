import java.time.LocalDate;
import java.time.Period;

/**
 * Represents a budget within a financial plan.
 * Extends the FinancialPlan class and adds the functionality to create a budget
 * based on the id, title, total amount, due date, and period.
 */
public class Budget extends FinancialPlan{
    /**
     * Constructs a new Budget with the specified details.
     * @param id The unique identifier for this budget.
     * @param title The title or description of the budget.
     * @param totalAmount The total amount allocated for the budget.
     * @param dueDate The due date for this budget.
     * @param period The period over which the budget is applied.
     */
    public Budget(int id, String title, float totalAmount, LocalDate dueDate, Period period) {
        super(id, title, totalAmount, dueDate, period);
    }
}
