public class IncomeView {
    public void displayIncome(Income taregetIncome) {
        System.out.println("Income date: " + taregetIncome.getDate());
        System.out.println("Income amount: " + taregetIncome.getAmount());
        System.out.println("Income source: " + taregetIncome.getSource());
        if (taregetIncome.isRecurring()){
            System.out.println("Income recurring");
        } else {
            System.out.println("Income not recurring");
        }
    }
}
