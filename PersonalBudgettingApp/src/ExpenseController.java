import java.util.List;

/**
 * Controller class responsible for managing and displaying budget entities.
 * Extends the AbstractController class to handle operations for Budget entities.
 * Part of the MVC design pattern
 */
public class ExpenseController extends AbstractController<Expense> {
    ExpenseView view;

    /**
     * Constructs a new ExpenseController.
     *
     * @param Expenses The list of Expense entities to be managed by the controller.
     * @param view    The ExpenseView used to display Expense entities.
     */
    public ExpenseController(List<Expense> Expenses, ExpenseView view) {
        super(Expenses);
        this.view = view;
    }

    /**
     * Displays the target Expense entity by matching its ID with those in the list of entities.
     * If a match is found, the corresponding Expense entity is displayed using the provided ExpenseView.
     *
     * @param targetExpense The Expense entity to be displayed.
     */
    @Override
    public void displayEntity(Expense targetExpense) {
        for (Expense candidateExpense : getEntities()) {
            if (candidateExpense.getId() == targetExpense.getId()) {
                view.displayExpense(candidateExpense);
            }
        }
    }

    /**
     * Displays all Expenses managed by the controller
     */
    @Override
    public void displayAllEntities() {
        for (Expense Expense : getEntities()) {
            view.displayExpense(Expense);
        }
    }
}
