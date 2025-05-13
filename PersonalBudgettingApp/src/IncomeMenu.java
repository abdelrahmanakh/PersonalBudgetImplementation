import java.util.Scanner;

/**
 * The {@code IncomeMenu} class provides a console-based menu interface
 * for managing the income sources of a specific user.
 * <p>
 * It allows users to:
 * <ul>
 *     <li>View all income sources</li>
 *     <li>Add new income sources</li>
 *     <li>Delete existing income sources</li>
 *     <li>Update existing income entries (title, amount, source, recurrence)</li>
 * </ul>
 *
 * This class relies on the MVC components {@code Income}, {@code IncomeController}, and {@code IncomeView}.
 * It uses a {@code Scanner} to capture user input and performs actions accordingly.
 */
public class IncomeMenu {
    private User currentUser;
    private Scanner scanner = new Scanner(System.in);
    /**
     * Constructs a new {@code IncomeMenu} for the given user.
     * @param user The user whose income sources will be managed.
     */
    IncomeMenu(User user) {
        this.currentUser = user;
    }

    /**
     * Displays the income management menu and handles user input.
     * <p>
     * The method loops until the user chooses to return.
     * It allows adding, deleting, and updating incomes, and displays the current list of incomes.
     * Changes are applied directly to the current user's income list.
     */
    public void showIncomeMenu() {
        while (true) {
            IncomeView incomeView = new IncomeView();
            IncomeController incomeController = new IncomeController(currentUser.getIncomeSources(), incomeView);
            System.out.println();
            System.out.println("Income Sources:");
            incomeController.displayAllEntities();
            System.out.println("1: Add new Income");
            System.out.println("2: Delete Income");
            System.out.println("3: Update Income");
            System.out.println("4: Return");
            int incomeChoice = scanner.nextInt();
            if (incomeChoice == 1) {
                int lastIndex = incomeController.getEntities().size();
                System.out.println("Enter Amount to add: ");
                float incomeAmount = scanner.nextFloat();
                System.out.println("Enter Income title: ");
                String incomeTitle = scanner.next();
                System.out.println("Enter Income Source: ");
                String incomeSource = scanner.next();
                System.out.println("1: if the income is recurring");
                System.out.println("2: if the income is not recurring");
                int incomeRecurringChoice = scanner.nextInt();
                boolean isIncomeRecurring;
                isIncomeRecurring = incomeRecurringChoice == 1;
                Income newIncome = new Income(lastIndex, incomeAmount, incomeTitle, incomeSource, isIncomeRecurring);
                incomeController.addEntity(newIncome);
            } else if (incomeChoice == 2) {
                System.out.println("Enter Income ID to be deleted: ");
                int incomeID = scanner.nextInt();
                incomeController.removeEntity(incomeID);
            } else if (incomeChoice == 3) {
                System.out.println("Enter Income ID to be updated: ");
                int incomeID = scanner.nextInt();
                Income incomeToBeUpdated = incomeController.getEntities().get(incomeID);
                while (true) {
                    incomeController.displayEntity(incomeToBeUpdated);
                    System.out.println("1: To change Income Title");
                    System.out.println("2: To change Income Source");
                    System.out.println("3: To change Income Amount");
                    System.out.println("4: To change Income Recurring State");
                    System.out.println("5: To Return");
                    int incomeUpdatingChoice = scanner.nextInt();
                    if (incomeUpdatingChoice == 1) {
                        System.out.println("Enter new Title: ");
                        incomeToBeUpdated.changeTitle(scanner.next());
                    } else if (incomeUpdatingChoice == 2) {
                        System.out.println("Enter new Source: ");
                        incomeToBeUpdated.updateSource(scanner.next());
                    } else if (incomeUpdatingChoice == 3) {
                        System.out.println("Enter new Amount: ");
                        incomeToBeUpdated.updateAmount(scanner.nextFloat());
                    } else if (incomeUpdatingChoice == 4) {
                        if (incomeToBeUpdated.isRecurring()) {
                            incomeToBeUpdated.cancelRecurring();
                        } else {
                            incomeToBeUpdated.makeRecurring();
                        }
                    } else if (incomeUpdatingChoice == 5) {
                        break;
                    } else {
                        System.out.println("Invalid Input!");
                    }
                }
            } else if (incomeChoice == 4) {
                break;
            } else {
                System.out.println("Invalid Input!");
            }
        }
    }
}
