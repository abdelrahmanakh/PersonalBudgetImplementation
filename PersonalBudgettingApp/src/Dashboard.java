public class Dashboard {
    User user;
    IncomeView incomeView;
    public Dashboard(User user) {
        this.user = user;
    }
    public void displayDashboard() {
        System.out.println("========================");
        System.out.println("Income:");
        for(Income income: user.incomeSources){
            incomeView.displayIncome(income);
            System.out.println();
        }
        System.out.println("========================");
    }
}
