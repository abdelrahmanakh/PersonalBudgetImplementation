import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Represents a reminder with a title, creation date, and time.
 * <p>
 * When a new Reminder object is created, it automatically records
 * the current date and time and prints the reminder to the console.
 * </p>
 *
 * Implements {@link Serializable} to allow reminders to be saved and restored.
 */
public class Reminder implements Serializable {
    private final String title;
    private final LocalDate date;
    private final LocalTime time;

    /**
     * Constructs a new Reminder with the given title.
     * The date and time are automatically set to the current system date and time.
     * Also prints the reminder to the console.
     *
     * @param title the title or description of the reminder
     */
    Reminder(String title) {
        this.title = title;
        date = LocalDate.now();
        time = LocalTime.now();

        System.out.println("\nREMINDER");
        System.out.println("------------");
        System.out.println(title);
    }

    /**
     * Returns the title of this reminder.
     *
     * @return the reminder's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the date when this reminder was created.
     *
     * @return the reminder's creation date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Returns the time when this reminder was created.
     *
     * @return the reminder's creation time
     */
    public LocalTime getTime() {
        return time;
    }
}
