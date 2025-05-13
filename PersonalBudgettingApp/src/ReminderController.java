import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReminderController implements Observer, Serializable {


    private List<Reminder> reminders = new ArrayList<Reminder>();

    ReminderController(List<Reminder> reminders) {
        this.reminders = reminders;
    }

    public void addReminder(Reminder reminder) {
        reminders.add(reminder);
    }

    public void editReminder(int idx, Reminder reminder) {
        reminders.set(idx, reminder);
    }

    public void deleteReminder(int index) {
        reminders.remove(index);
    }

    public Reminder getReminder(int idx) {
        return reminders.get(idx);
    }

    public List<Reminder> getReminders() {
        return reminders;
    }

    public void sendReminder(Reminder reminder) {
        addReminder(reminder);
    }


    @Override
    public void update(String title) {
        sendReminder(new Reminder(title));
    }
}
