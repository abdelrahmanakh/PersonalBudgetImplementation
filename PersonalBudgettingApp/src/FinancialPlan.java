import java.time.Period;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a financial plan with an id, due date, period, total and paid amounts, and recurrence options.
 * Implements the Subject part of the Observer design pattern.
 */
public class FinancialPlan implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private final int id;
    private float totalAmount, paidAmount;
    private String title;
    private boolean isRecurring;
    private LocalDate dueDate;
    private Period period;

    /**
     * Constructs a new FinancialPlan.
     * @param id           Unique identifier of the plan.
     * @param title        Title of the financial plan.
     * @param totalAmount  Total amount planned.
     * @param dueDate      Due date for the plan.
     * @param period       Period for the recurrence option
     */
    public FinancialPlan(int id, String title, float totalAmount, LocalDate dueDate, Period period) {
        this.id = id;
        this.title = title;
        this.totalAmount = totalAmount;
        this.paidAmount = 0;
        this.dueDate = dueDate;
        this.period =period;
        this.isRecurring = true;
    }

    // === Subject Interface Methods ===

    /**
     * Adds an observer to the list.
     * @param o The observer to add.
     */
    public void addObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Removes an observer from the list.
     * @param o The observer to remove.
     */
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    /**
     * Notifies all observers if the due date is soon.
     */
    public void notifyObservers() {
        for (Observer o : observers) {
            if (isDueDateSoon())
                o.update(title);
        }
    }

    // === Utility Methods ===

    /**
     * Checks whether the due date is within 7 days from today.
     * @return True if due date is within 7 days, false otherwise.
     */
    public boolean isDueDateSoon() {
        LocalDate now = LocalDate.now();
        Period p = Period.between(now, dueDate);
        return p.getYears() == 0 && p.getMonths() == 0 && p.getDays() <= 7;
    }

    /**
     * Checks whether the paid amount is at least 70%.
     * @return True if paid amount is 70% or greater of the total amount, false otherwise.
     */
    public boolean isPaidAboveThreshold() {
        return paidAmount >= 0.7 * totalAmount;
    }
    // === Getters and Setters ===

    /**
     * @return The unique ID of this plan.
     */
    public int getId() {
        return id;
    }

    /**
     * @return The title of the plan.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the plan.*
     * @param title New title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The total amount of the plan.
     */
    public float getTotalAmount() {
        return totalAmount;
    }

    /**
     * Sets the total amount of the plan.
     * @param totalAmount New total amount.
     */
    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return The paid amount so far.
     */
    public float getPaidAmount() {
        return paidAmount;
    }

    /**
     * Deposits to the paid amount of the plan.
     * @param depositedAmount the amount to be deposited.
     */
    public void depositAmount(float depositedAmount) {
        this.paidAmount += depositedAmount;
    }

    /**
     * Withdraw from the paid amount of the plan
     * @param withdrawnAmount the amount to be withdrawn from the plan.
     */
    public void withdrawAmount(float withdrawnAmount) {
        this.paidAmount -= withdrawnAmount;
    }

    /**
     * @return Whether the plan is recurring.
     */
    public boolean isRecurring() {
        return isRecurring;
    }

    /**
     * Marks the plan as recurring.
     */
    public void makeRecurring() {
        isRecurring = true;
    }

    /**
     * Cancels the recurrence of the plan.
     */
    public void cancelRecurring() {
        isRecurring = false;
    }

    /**
     * @return The due date of the plan.
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date of the plan.
     * @param dueDate New due date.
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * @return The period from due date to now.
     */
    public Period getPeriod() {
        return period;
    }

    /**
     * Sets the period between due date and current date.
     * @param period New period.
     */
    public void setPeriod(Period period) {
        this.period = period;
    }

}
