import java.util.Scanner;
import java.io.*;


public class Main {
    private static final String FILENAME = "users.ser";
    public static UserController userController = new UserController();
    public static User currentUser;
    public static ReminderController reminderController = new ReminderController();

    public static void main(String[] args) throws Exception {
        userController = loadData();
        System.out.println("Current working directory: " + System.getProperty("user.dir"));
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the User Management System!");
        System.out.println("Choose from the following:");
        System.out.println("1: Sign-up");
        System.out.println("2: Login");
        int choice;
        choice = scanner.nextInt();
        if (choice == 1) {
            while (true) {
                System.out.println("**Sign-up menu**");
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter email: ");
                String email = scanner.next();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();

                SignUpRequest signUpRequest = new SignUpRequest(username, email, password, phoneNumber);
                if (signUpRequest.isValidRequest()) {
                    userController.createUser(signUpRequest);
                    saveData(userController);
                    break;
                }
            }
        }
        while (true) {
            System.out.println("**Login menu**");
            System.out.print("Enter email: ");
            String email = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();

            int ID = userController.login(email, password);
            if (ID != -1) {
                currentUser = userController.users.get(ID);
                System.out.println("Login successful!");
                break;
            }
            System.out.println("Invalid email or password. Please try again.");
        }
        if (currentUser != null) {
            Dashboard dashboard = new Dashboard(currentUser);
            while (true) {
                saveData(userController);
                dashboard.displayDashboard();
                System.out.println("Where do you want to go?");
                System.out.println("1: Income");
                System.out.println("2: Expense");
                System.out.println("3: Budgets");
                System.out.println("4: Reminders");
                System.out.println("5: Delete account");
                System.out.println("6: Exit");
                int dashboardChoice = scanner.nextInt();
                if (dashboardChoice == 1) {
                    IncomeMenu incomeMenu = new IncomeMenu(currentUser);
                    incomeMenu.showIncomeMenu();
                } else if (dashboardChoice == 2) {
                    while (true) {
                        ExpenseView expenseView = new ExpenseView();
                        ExpenseController expenseController = new ExpenseController(currentUser.getExpenseRecipients(), expenseView);
                        System.out.println();
                        System.out.println("Expense Recipients:");
                        expenseController.displayAllEntities();
                        System.out.println("1: Add new Expense");
                        System.out.println("2: Delete Expense");
                        System.out.println("3: Update Expense");
                        System.out.println("4: Return");
                        int expenseChoice = scanner.nextInt();
                        if (expenseChoice == 1) {
                            int lastIndex = expenseController.getEntities().size();
                            System.out.println("Enter Amount to add: ");
                            float expenseAmount = scanner.nextFloat();
                            System.out.println("Enter Expense title: ");
                            String expenseTitle = scanner.next();
                            System.out.println("Enter Expense Recipients: ");
                            String expenseSource = scanner.next();
                            System.out.println("1: if the expense is recurring");
                            System.out.println("2: if the expense is not recurring");
                            int expenseRecurringChoice = scanner.nextInt();
                            boolean isExpenseRecurring;
                            isExpenseRecurring = expenseRecurringChoice == 1;
                            Expense newExpense = new Expense(lastIndex, expenseAmount, expenseTitle, expenseSource, isExpenseRecurring);
                            expenseController.addEntity(newExpense);
                        } else if (expenseChoice == 2) {
                            System.out.println("Enter Expense ID to be deleted: ");
                            int expenseID = scanner.nextInt();
                            expenseController.removeEntity(expenseID);
                        } else if (expenseChoice == 3) {
                            System.out.println("Enter expense ID to be updated: ");
                            int expenseID = scanner.nextInt();
                            Expense expenseToBeUpdated = expenseController.getEntities().get(expenseID);
                            while (true) {
                                expenseController.displayEntity(expenseToBeUpdated);
                                System.out.println("1: To change Expense Title");
                                System.out.println("2: To change Expense Source");
                                System.out.println("3: To change Expense Amount");
                                System.out.println("4: To change Expense Recurring State");
                                System.out.println("5: To Return");
                                int expenseUpdatingChoice = scanner.nextInt();
                                if (expenseUpdatingChoice == 1) {
                                    System.out.println("Enter new Title: ");
                                    expenseToBeUpdated.changeTitle(scanner.next());
                                } else if (expenseUpdatingChoice == 2) {
                                    System.out.println("Enter new Recipient: ");
                                    expenseToBeUpdated.updateRecipient(scanner.next());
                                } else if (expenseUpdatingChoice == 3) {
                                    System.out.println("Enter new Amount: ");
                                    expenseToBeUpdated.updateAmount(scanner.nextFloat());
                                } else if (expenseUpdatingChoice == 4) {
                                    if (expenseToBeUpdated.isRecurring()) {
                                        expenseToBeUpdated.cancelRecurring();
                                    } else {
                                        expenseToBeUpdated.makeRecurring();
                                    }
                                } else if (expenseUpdatingChoice == 5) {
                                    break;
                                } else {
                                    System.out.println("Invalid Input!");
                                }
                            }
                        } else if (expenseChoice == 4) {
                            break;
                        } else {
                            System.out.println("Invalid Input!");
                        }
                    }
                } else if (dashboardChoice == 3) {
                    BudgetMenu budgetMenu = new BudgetMenu(currentUser, reminderController);
                    budgetMenu.showBudgetMenu();
                } else if (dashboardChoice == 4) {
                    ReminderView reminderView = new ReminderView();
                    while (true) {
                        reminderView.displayReminder(reminderController);
                        System.out.println("1. Delete a Reminder");
                        System.out.println("2. Exit");
                        int deleteChoice = scanner.nextInt();
                        if (deleteChoice == 1) {
                            System.out.println("Enter the index to delete (0-indexed)");
                            int index = scanner.nextInt();
                            reminderController.deleteReminder(index);
                        } else if (choice == 2) {
                            break;
                        } else {
                            System.err.println("Invalid Choice");
                        }
                    }
                } else if (dashboardChoice == 5) {
                    userController.deleteUser(currentUser);
                    break;
                } else if (dashboardChoice == 6) {
                    break;
                } else {
                    System.out.println("Invalid Input!");
                }
            }
        }
        scanner.close();
    }

    public static void saveData(UserController usersToSave) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(FILENAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // Serialize the entire list object to the file
            oos.writeObject(usersToSave);
        }
    }

    public static UserController loadData() throws Exception {
        UserController usersToLoad;
        try (FileInputStream fis = new FileInputStream(FILENAME);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            usersToLoad = (UserController) ois.readObject();
        }
        return usersToLoad;
    }
}

