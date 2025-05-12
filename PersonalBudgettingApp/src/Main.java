import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Main {
    public static UserController userController = new UserController();
    public static User currentUser;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the User Management System!");
        System.out.println("Choose from the following:");
        System.out.println("1: Sign-in");
        System.out.println("2: Login");
        int choice;
        choice = scanner.nextInt();
        if (choice == 1) {
            while (true) {
                System.out.print("Enter username: ");
                String username = scanner.next();
                System.out.print("Enter email: ");
                String email = scanner.next();
                System.out.print("Enter phone number: ");
                String phoneNumber = scanner.next();
                System.out.print("Enter password: ");
                String password = scanner.next();

                SignUpRequest signUpRequest = new SignUpRequest(username, email, password, phoneNumber);
                if (signUpRequest.isValidRequest()) break;
            }
        }
        while (true) {
            System.out.print("Enter email: ");
            String email = scanner.next();
            System.out.print("Enter password: ");
            String password = scanner.next();

            int ID = userController.login(email, password);
            if (ID != -1) {
                currentUser = userController.users.get(ID);
                break;
            }
            System.out.println("Invalid email or password. Please try again.");
        }
        if(currentUser!=null){
            Dashboard dashboard = new Dashboard(currentUser);
            dashboard.displayDashboard();
            while(true){
                System.out.println("Where do you want to go?");
                System.out.println("1: Income");
                System.out.println("2: Expense");
                System.out.println("3: Budgets");
                System.out.println("4: Exit");
                int dashboardChoice = scanner.nextInt();
                if (dashboardChoice == 1) {
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
                        int  incomeChoice = scanner.nextInt();
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
                                } else if(incomeUpdatingChoice == 5){
                                    break;
                                } else {
                                    System.out.println("Invalid Input!");
                                }
                            }
                        }  else if (incomeChoice == 4) {
                            break;
                        } else {
                            System.out.println("Invalid Input!");
                        }
                    }
                } else if (dashboardChoice == 3){
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
                            System.out.println("Enter Year: ");
                            int budgetDueDateYear = scanner.nextInt();
                            System.out.println("Enter Month: ");
                            int budgetDueDateMonth = scanner.nextInt();
                            System.out.println("Enter Day: ");
                            int budgetDueDateDay = scanner.nextInt();
                            LocalDate budgetDueDate =  LocalDate.of(budgetDueDateYear, budgetDueDateMonth, budgetDueDateDay);
                            System.out.println("Enter Budget Period: ");
                            System.out.println("Enter Year: ");
                            int budgetPeriodYear = scanner.nextInt();
                            System.out.println("Enter Month: ");
                            int budgetPeriodMonth = scanner.nextInt();
                            System.out.println("Enter Day: ");
                            int budgetPeriodDay = scanner.nextInt();
                            Period budgetPeriod = Period.of(budgetPeriodYear, budgetPeriodMonth, budgetPeriodDay);
                            Budget newBudget = new Budget(lastIndex, budgetTitle, budgetTotalAmount, budgetDueDate, budgetPeriod);
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
                                System.out.println("6: To Return");
                                int  budgetUpdatingChoice = scanner.nextInt();
                                if (budgetUpdatingChoice == 1) {
                                    System.out.println("Enter new Budget Amount: ");
                                    budgetToBeUpdated.setTotalAmount(scanner.nextFloat());
                                } else if (budgetUpdatingChoice == 2) {
                                    System.out.println("Enter new Budget Title/Category: ");
                                    budgetToBeUpdated.setTitle(scanner.next());
                                }  else if (budgetUpdatingChoice == 3) {
                                    System.out.println("Enter new Budget Due Date: ");
                                    System.out.println("Enter Year: ");
                                    int budgetDueDateYear = scanner.nextInt();
                                    System.out.println("Enter Month: ");
                                    int budgetDueDateMonth = scanner.nextInt();
                                    System.out.println("Enter Day: ");
                                    int budgetDueDateDay = scanner.nextInt();
                                    LocalDate budgetDueDate = LocalDate.of(budgetDueDateYear, budgetDueDateMonth, budgetDueDateDay);
                                    budgetToBeUpdated.setDueDate(budgetDueDate);
                                } else  if (budgetUpdatingChoice == 4) {
                                    System.out.println("Enter new Budget Period: ");
                                    System.out.println("Enter Year: ");
                                    int budgetPeriodYear = scanner.nextInt();
                                    System.out.println("Enter Month: ");
                                    int budgetPeriodMonth = scanner.nextInt();
                                    System.out.println("Enter Day: ");
                                    int budgetPeriodDay = scanner.nextInt();
                                    Period budegtePeriod = Period.of(budgetPeriodYear, budgetPeriodMonth, budgetPeriodDay);
                                    budgetToBeUpdated.setPeriod(budegtePeriod);
                                } else if (budgetUpdatingChoice == 5) {
                                    System.out.println("Enter Amount to deposit: ");
                                    budgetToBeUpdated.depositAmount(scanner.nextFloat());
                                } else if (budgetUpdatingChoice == 6) {
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
                } else if (dashboardChoice == 4){
                    break;
                } else {
                    System.out.println("Invalid Input!");
                }
            }
        }
    }
}
