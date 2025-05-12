/**
 * View class responsible for displaying the details of an Expense entity.
 * This class is part of the MVC design pattern and interacts with the ExpenseController
 * to display the details of the Expense entity.
 */
public class ExpenseView {
    /**
     * Displays the details of a given Expense, including date, amount, recipient, and whether it's recurring.
     * @param targetExpense The Expense entity to be displayed.
     */
    public void displayExpense(Expense targetExpense) {
        System.out.println("Expense date: " + targetExpense.getDate());
        System.out.println("Expense amount: " + targetExpense.getAmount());
        System.out.println("Expense recipient: " + targetExpense.getRecipient());
        if (targetExpense.isRecurring()){
            System.out.println("Expense recurring");
        } else {
            System.out.println("Expense not recurring");
        }
    }
}
