import java.time.format.DateTimeFormatter;

/**
 * The {@code ReminderView} class is responsible for displaying reminder details
 * to the console in a formatted way. It supports viewing single reminders
 * or all reminders managed by a {@link ReminderController}.
 */
public class ReminderView {

    /**
     * Displays the details of a given {@link Reminder}, including title, date, and formatted time.
     *
     * @param reminder the {@code Reminder} object to display
     */
    public void displayReminder(Reminder reminder) {
        System.out.println("Reminder title: " + reminder.getTitle());
        System.out.println("Reminder Date: " + reminder.getDate());
        System.out.println("Reminder Time: " + reminder.getTime().format(DateTimeFormatter.ofPattern("HH:mm")));
        System.out.println();
    }

    /**
     * Displays a specific reminder from a {@link ReminderController} by its index.
     *
     * @param RC    the {@code ReminderController} managing the reminders
     * @param index the index of the reminder to display
     */
    public void displayReminder(ReminderController RC, int index) {
        Reminder reminder = RC.getReminder(index);
        displayReminder(reminder);
    }

    /**
     * Displays all reminders managed by the given {@link ReminderController}.
     *
     * @param RC the {@code ReminderController} containing the reminders to display
     */
    public void displayReminder(ReminderController RC) {
        for (Reminder reminder : RC.getReminders()) {
            displayReminder(reminder);
        }
    }
}
