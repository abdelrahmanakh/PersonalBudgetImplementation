import java.time.LocalDate;
import java.time.Period;

public class Budget extends FinancialPlan{
    public Budget(int id, String title, int totalAmount, LocalDate dueDate, Period period) {
        super(id, title, totalAmount, dueDate, period);
    }
}
