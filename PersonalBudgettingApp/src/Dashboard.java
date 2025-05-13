public class Dashboard {
    User user;
    IncomeView incomeView;
    BudgetView budgetView;
    public Dashboard(User user) {
        this.user = user;
    }
    public void displayDashboard() {
        System.out.println("========================");
        float totalIncome = 0;
        for(Income income: user.getIncomeSources()){
            totalIncome += income.getAmount();
        }
        System.out.println("Total Income: " + totalIncome);
        if(user.getIncomeSources().isEmpty()){
            System.out.println("No Income sources have been added.");
        } else{
            System.out.println("Latest Income source have been added:");
            Income lastIncome = user.getIncomeSources().get(user.getIncomeSources().size()-1);
            incomeView.displayIncome(lastIncome);
        }

        System.out.println("========================");
        if(user.getBudgets().isEmpty()){
            System.out.println("No Budgets have been added.");
        } else{
            System.out.println("Latest Budget have been added:");
            Budget lastBudget = user.getBudgets().get(user.getBudgets().size()-1);
            budgetView.displayBudget(lastBudget);
        }
        System.out.println("========================");
    }
}
