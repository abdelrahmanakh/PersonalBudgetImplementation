import java.time.Period;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class FinancialPlan {
    List<Observer> observers;
    int id;
    String title;
    int totalAmount;
    int paidAmount;
    boolean isRecurring;
    LocalDate dueDate;
    Period period;

    public FinancialPlan(int id, String title, int totalAmount, LocalDate dueDate, Period period) {
        this.id = id;
        this.title = title;
        this.totalAmount = totalAmount;
        this.dueDate = dueDate;
        this.period = period;
    }

    //Subject Class implementation
    public void addObserver(Observer o) {
        observers.add(o);
    }
    public void removeObserver(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }

    //Method to see if the dueDate is soon
    public boolean isDueDateSoon(){
        LocalDate now = LocalDate.now();
        Period p = Period.between(dueDate, now);
        return p.getYears() == 0 && p.getMonths() == 0 && p.getDays() <= 7;
    }

    //ID getter
    public int getId() {
        return id;
    }

    //Title getter and setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    //totalAmount getter and setter
    public int getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    //paidAmount getter and setter
    public int getPaidAmount() {
        return paidAmount;
    }
    public void setPaidAmount(int paidAmount) {
        this.paidAmount = paidAmount;
    }

    //isRecurring getter and setter
    public boolean isRecurring() {
        return isRecurring;
    }
    public void setRecurring(boolean recurring) {
        isRecurring = recurring;
    }

    //dueDate getter and setter
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    //period getter and setter
    public Period getPeriod() {
        return period;
    }
    public void setPeriod(Period period) {
        this.period = period;
    }

}
