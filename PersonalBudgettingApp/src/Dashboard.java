public class Dashboard {
    User user;
    IncomeView incomeView;
    BudgetView budgetView;
    public Dashboard(User user) {
        this.user = user;
    }
    public void displayDashboard() {
        System.out.println("========================");
        System.out.println("Income:");
        for(Income income: user.getIncomeSources()){
            incomeView.displayIncome(income);
            System.out.println();
        }
        System.out.println("========================");
        for(Budget budget: user.getBudgets()){
            budgetView.displayBudget(budget);
            System.out.println();
        }
        System.out.println("========================");
    }
}
