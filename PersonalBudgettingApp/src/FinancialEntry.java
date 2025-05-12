import java.time.LocalDate;

public class FinancialEntry {
    private int id, amount;
    private String title;
    private boolean isRecurring;
    private LocalDate date;

    public FinancialEntry(int id, int amount, String title, boolean isRecurring) {
        this.id = id;
        this.amount = amount;
        this.title = title;
        this.isRecurring = isRecurring;
        this.date = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
    public void updateAmount(int amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }
    public void changeTitle(String title) {
        this.title = title;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void makeRecurring() {
        this.isRecurring = true;
    }

    public void cancelRecurring() {
        this.isRecurring = false;
    }
    public LocalDate getDate() {
        return date;
    }
}
