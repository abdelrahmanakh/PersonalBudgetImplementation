public class Dashboard {
    User user;
    IncomeView incomeView;
    ExpenseView expenseView;
    BudgetView budgetView;

    public Dashboard(User user) {
        this.user = user;
    }

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
