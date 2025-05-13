import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The {@code BudgetMenu} class handles user interactions related to managing budgets.
 * It allows the user to add, delete, and update budgets through a command-line interface.
 * The class also interacts with a {@code ReminderController} to set up reminders
 * for budget due dates.
 */
public class BudgetMenu {
    private User currentUser;
    private Scanner scanner = new Scanner(System.in);
    private ReminderController reminderController;
    /**
     * Constructs a new {@code BudgetMenu} for the given user and reminder controller.
     * @param user               the current user interacting with the budget menu
     * @param reminderController the controller responsible for handling reminders
     */
    BudgetMenu(User user,  ReminderController reminderController) {
        this.currentUser = user;
        this.reminderController = reminderController;
    }

    /**
     * Displays the budget menu and handles user input for adding,
     * deleting, and updating budgets.
     *
     * <p>This method runs in a loop until the user chooses to return.</p>
     *
     * <p>Operations include:</p>
     * <ul>
     *   <li>Adding a new budget with title, amount, due date, and period</li>
     *   <li>Deleting an existing budget by ID</li>
     *   <li>Updating attributes of an existing budget</li>
     * </ul>
     */
    public void showBudgetMenu() {
        while (true) {
            BudgetView budgetView = new BudgetView();
            BudgetController budgetController = new BudgetController(currentUser.getBudgets(), budgetView);
            System.out.println();
            System.out.println("Budgets:");
            budgetController.displayAllEntities();
            System.out.println("1: Add new Budget");
            System.out.println("2: Delete Budget");
            System.out.println("3: Update Budget");
            System.out.println("4: Return");
            int budgetChoice = scanner.nextInt();
            if (budgetChoice == 1) {
                int lastIndex = budgetController.getEntities().size();
                System.out.println("Enter Budget Amount: ");
                float budgetTotalAmount = scanner.nextFloat();
                System.out.println("Enter Budget title/category: ");
                String budgetTitle = scanner.next();
                System.out.println("Enter Budget Due Date: ");
                List<Integer> dueDateAndPeriod = dueDateAndPeriodMenu();
                LocalDate budgetDueDate = LocalDate.of(dueDateAndPeriod.get(0), dueDateAndPeriod.get(1), dueDateAndPeriod.get(2));
                System.out.println("Enter Budget Period: ");
                dueDateAndPeriod = dueDateAndPeriodMenu();
                Period budgetPeriod = Period.of(dueDateAndPeriod.get(0), dueDateAndPeriod.get(1), dueDateAndPeriod.get(2));
                Budget newBudget = new Budget(lastIndex, budgetTitle, budgetTotalAmount, budgetDueDate, budgetPeriod);
                newBudget.addObserver(reminderController);
                budgetController.addEntity(newBudget);
            } else if (budgetChoice == 2) {
                System.out.println("Enter Budget ID to be deleted: ");
                int budgetID = scanner.nextInt();
                budgetController.removeEntity(budgetID);
            } else if (budgetChoice == 3) {
                System.out.println("Enter Budget ID to be updated: ");
                int budgetID = scanner.nextInt();
                Budget budgetToBeUpdated = budgetController.getEntities().get(budgetID);
                while (true) {
                    budgetController.displayEntity(budgetToBeUpdated);
                    System.out.println("1: To change Budget Amount");
                    System.out.println("2: To change Budget Title/Category");
                    System.out.println("3: To change Budget Due Date");
                    System.out.println("4: To change Budget Period");
                    System.out.println("5: To deposit");
                    System.out.println("6: To withdraw");
                    System.out.println("7: To Return");

                    int budgetUpdatingChoice = scanner.nextInt();
                    if (budgetUpdatingChoice == 1) {
                        System.out.println("Enter new Budget Amount: ");
                        budgetToBeUpdated.setTotalAmount(scanner.nextFloat());
                    } else if (budgetUpdatingChoice == 2) {
                        System.out.println("Enter new Budget Title/Category: ");
                        budgetToBeUpdated.setTitle(scanner.next());
                    } else if (budgetUpdatingChoice == 3) {
                        System.out.println("Enter new Budget Due Date: ");
                        List<Integer> dueDateAndPeriod = dueDateAndPeriodMenu();
                        LocalDate budgetDueDate = LocalDate.of(dueDateAndPeriod.get(0), dueDateAndPeriod.get(1), dueDateAndPeriod.get(2));
                        budgetToBeUpdated.setDueDate(budgetDueDate);
                    } else if (budgetUpdatingChoice == 4) {
                        System.out.println("Enter new Budget Period: ");
                        List<Integer> dueDateAndPeriod = dueDateAndPeriodMenu();
                        Period budgetPeriod = Period.of(dueDateAndPeriod.get(0), dueDateAndPeriod.get(1), dueDateAndPeriod.get(2));
                        budgetToBeUpdated.setPeriod(budgetPeriod);
                    } else if (budgetUpdatingChoice == 5) {
                        System.out.println("Enter Amount to deposit: ");
                        budgetToBeUpdated.depositAmount(scanner.nextFloat());
                    } else if (budgetUpdatingChoice == 6) {
                        System.out.println("Enter Amount to withdraw: ");
                        budgetToBeUpdated.withdrawAmount(scanner.nextFloat());
                    } else if (budgetUpdatingChoice == 7) {
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                    }
                }
            } else if (budgetChoice == 4) {
                break;
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }
    /**
     * Prompts the user to enter a date (year, month, day) and returns it as a list of integers.
     * @return a list containing year, month, and day as integers
     */
    public List<Integer> dueDateAndPeriodMenu (){
        List<Integer> dueDateAndPeriod =  new ArrayList<>();
        System.out.println("Enter Year: ");
        int budgetDueDateYear = scanner.nextInt();
        System.out.println("Enter Month: ");
        int budgetDueDateMonth = scanner.nextInt();
        System.out.println("Enter Day: ");
        int budgetDueDateDay = scanner.nextInt();
        dueDateAndPeriod.add(budgetDueDateYear);
        dueDateAndPeriod.add(budgetDueDateMonth);
        dueDateAndPeriod.add(budgetDueDateDay);
        return dueDateAndPeriod;
    }
}
