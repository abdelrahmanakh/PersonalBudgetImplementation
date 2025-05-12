import java.time.LocalDate;
import java.time.LocalTime;


public class Reminder {
    private final String title;
    private final LocalDate date;
    private final LocalTime time;

    Reminder(String title) {
        this.title = title;
        date = LocalDate.now();
        time = LocalTime.now();

        System.out.println("\nREMINDER");
        System.out.println("------------");
        System.out.println(title);
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
