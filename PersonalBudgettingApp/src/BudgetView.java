/**
 * View class responsible for displaying the details of a Budget.
 * This class is part of the MVC design pattern and interacts with the BudgetController
 * to display the details of the Income entity.
 */
public class BudgetView{
    /**
     * Displays the details of a given Budget, including title, remaining budget, and due date.
     * @param budget The Budget entity to be displayed.
     */
    public void displayBudget (Budget budget){
        System.out.println("Budget title: "+ budget.getTitle());
        System.out.println("Remaining Budget: " + (budget.getTotalAmount() - budget.getPaidAmount()) + " from total budget " + budget.getTotalAmount());
        System.out.println("Due date: "+ budget.getDueDate());
    }
}
