import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;


public class Reminder {
    String title;
    LocalDate date;
    LocalTime time;
    public LocalDateTime datetime;

    Reminder(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
        datetime = LocalDateTime.of(date, time);
    }

    public void sendReminder() {
        System.out.println("\nREMINDER");
        System.out.println("------------");
        System.out.println(title);
    }

    public void display() {
        System.out.println(title);
        System.out.println(date);
        System.out.println(time);
    }
}
