/**
 * The {@code Dashboard} class is responsible for displaying a summary view
 * of a user's financial data, including income sources, expenses, and budgets.
 * It interacts with {@code IncomeView}, {@code ExpenseView}, and {@code BudgetView}
 * to present the latest entries and totals.
 */
public class Dashboard {
    /** The user whose financial data is being displayed. */
    User user;
    /** View component for displaying income information. */
    IncomeView incomeView = new IncomeView();
    /** View component for displaying expense information. */
    ExpenseView expenseView = new ExpenseView();
    /** View component for displaying budget information. */
    BudgetView budgetView  = new BudgetView();

    /**
     * Constructs a {@code Dashboard} for the given user.
     * @param user the user whose dashboard is to be displayed
     */
    public Dashboard(User user) {
        this.user = user;
    }

    /**
     * Displays the user's dashboard, including:
     * <ul>
     *     <li>Total income and the most recent income source (if any)</li>
     *     <li>Total expenses and the most recent expense (if any)</li>
     *     <li>The most recently added budget (if any)</li>
     * </ul>
     * The output is printed to the console and is divided into sections.
     */
    public void displayDashboard() {
        System.out.println("========================");
        float totalIncome = 0;
        for (Income income : user.getIncomeSources()) {
            totalIncome += income.getAmount();
        }
        System.out.println("Total Income: " + totalIncome);
        if (user.getIncomeSources().isEmpty()) {
            System.out.println("No Income sources have been added.");
        } else {
            System.out.println("Latest Income source have been added:");
            Income lastIncome = user.getIncomeSources().getLast();
            incomeView.displayIncome(lastIncome);
        }

        System.out.println("========================");

        float totalExpense = 0;
        for (Expense expense : user.getExpenseRecipients()) {
            totalExpense += expense.getAmount();
        }
        System.out.println("Total Expense: " + totalExpense);
        if (user.getExpenseRecipients().isEmpty()) {
            System.out.println("No Expense sources have been added.");
        } else {
            System.out.println("Latest Expense source have been added:");
            Expense lastExpense = user.getExpenseRecipients().getLast();
            expenseView.displayExpense(lastExpense);
        }

        System.out.println("========================");
        if (user.getBudgets().isEmpty()) {
            System.out.println("No Budgets have been added.");
        } else {
            System.out.println("Latest Budget have been added:");
            Budget lastBudget = user.getBudgets().getLast();
            budgetView.displayBudget(lastBudget);
        }
        System.out.println("========================");
    }
}
