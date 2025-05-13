import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for managing a list of {@link Reminder} objects.
 * <p>
 * This class implements the {@link Observer} interface and can receive updates
 * in the form of reminder titles, which are automatically converted into
 * {@link Reminder} objects and added to the list.
 * </p>
 *
 * Implements {@link Serializable} to allow instances to be serialized.
 */
public class ReminderController implements Observer, Serializable {

    /**
     * The list of reminders managed by this controller.
     */
    private final List<Reminder> reminders;

    /**
     * Constructs a ReminderController with an initial list of reminders.
     *
     * @param reminders the list of existing reminders
     */
    ReminderController(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    /**
     * Adds a new reminder to the list.
     *
     * @param reminder the reminder to be added
     */
    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
    }

    /**
     * Replaces the reminder at the specified index with a new reminder.
     *
     * @param idx      the index of the reminder to be edited
     * @param reminder the new reminder to replace the old one
     */
    public void editReminder(int idx, Reminder reminder) {
        reminders.set(idx, reminder);
    }

    /**
     * Deletes the reminder at the specified index.
     *
     * @param index the index of the reminder to be deleted
     */
    public void deleteReminder(int index) {
        reminders.remove(index);
    }

    /**
     * Retrieves the reminder at the specified index.
     *
     * @param idx the index of the reminder
     * @return the reminder at the given index
     */
    public Reminder getReminder(int idx) {
        return reminders.get(idx);
    }

    /**
     * Returns the list of all reminders.
     *
     * @return the list of reminders
     */
    public List<Reminder> getReminders() {
        return reminders;
    }

    /**
     * Adds a reminder to the list. Internally used for processing updates.
     *
     * @param reminder the reminder to be added
     */
    public void sendReminder(Reminder reminder) {
        addReminder(reminder);
    }

    /**
     * Receives an update (a new reminder title) and adds it as a reminder.
     * Part of the {@link Observer} interface implementation.
     *
     * @param title the title of the reminder received from the observable
     */
    @Override
    public void update(String title) {
        sendReminder(new Reminder(title));
    }
}
