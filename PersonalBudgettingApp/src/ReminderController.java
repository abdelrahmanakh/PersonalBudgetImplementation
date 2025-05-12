import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.time.LocalDateTime;

public class ReminderController {
    List<Reminder> reminders;


//        System.out.print("Enter date (yyyy-MM-dd): ");
//        String dateInput = scanner.nextLine();
//        System.out.print("Enter time (HH:mm): ");
//        String timeInput = scanner.nextLine();

    public void addReminder(String dateInput, String timeInput) {
        LocalDate date = LocalDate.parse(dateInput);
        LocalTime time = LocalTime.parse(timeInput);
        reminders.add(new Reminder(date, time));
    }

    public void displayReminder(int index) {
        reminders.get(index).display();
    }

    public void editReminder(int idx, String dateInput, String timeInput) {
        LocalDate date = LocalDate.parse(dateInput);
        LocalTime time = LocalTime.parse(timeInput);
        reminders.set(idx, new Reminder(date, time));
    }

    public void deleteReminder(int index) {
        reminders.remove(index);
    }

    public void checkReminders() {
        LocalDateTime currentDateTime = LocalDateTime.now();
        for (int i = 0; i < reminders.size(); ) {
            if (currentDateTime.isAfter(reminders.get(i).datetime)) {
                reminders.get(i).sendReminder();
                deleteReminder(i);
            } else
                i++;
        }
    }
}
