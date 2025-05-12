public class ReminderView {
    /**
     * Displays the details of a given Reminder, including title, date, and time
     *
     * @param reminder The Reminder entity to be displayed.
     */
    public void displayReminder(Reminder reminder) {
        System.out.println("Reminder title: " + reminder.getTitle());
        System.out.println("Remaining Date: " + reminder.getDate());
        System.out.println("Remaining Time: " + reminder.getTime());
    }

    public void displayReminder(ReminderController RC, int index) {
        Reminder reminder = RC.getReminder(index);
        displayReminder(reminder);
    }
}
