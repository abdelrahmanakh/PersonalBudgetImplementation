/**
 * View class responsible for displaying the details of an Income entity.
 * This class is part of the MVC design pattern and interacts with the IncomeController
 * to display the details of the Income entity.
 */
public class IncomeView {
    /**
     * Displays the details of a given Income, including date, amount, source, and whether it's recurring.
     * @param targetIncome The Income entity to be displayed.
     */
    public void displayIncome(Income targetIncome) {
        System.out.println("Income date: " + targetIncome.getDate());
        System.out.println("Income amount: " + targetIncome.getAmount());
        System.out.println("Income source: " + targetIncome.getSource());
        if (targetIncome.isRecurring()){
            System.out.println("Income recurring");
        } else {
            System.out.println("Income not recurring");
        }
    }
}
