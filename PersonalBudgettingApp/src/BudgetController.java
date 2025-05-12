import java.util.List;

/**
 * Controller class responsible for managing and displaying budget entities.
 * Extends the AbstractController class to handle operations for Budget entities.
 * Part of the MVC design pattern
 */
public class BudgetController extends AbstractController<Budget> {
    BudgetView view;

    /**
     * Constructs a new BudgetController.
     * @param budgets The list of Budget entities to be managed by the controller.
     * @param view The BudgetView used to display Budget entities.
     */
    public BudgetController(List<Budget> budgets, BudgetView view){
        super(budgets);
        this.view = view;
    }

    /**
     * Displays the target Budget entity by matching its ID with those in the list of entities.
     * If a match is found, the corresponding Budget entity is displayed using the provided BudgetView.
     * @param targetBudget The Budget entity to be displayed.
     */
    @Override
    public void displayEntity(Budget targetBudget) {
        for (Budget candidateBudget:getEntities()) {
            if(candidateBudget.getId() == targetBudget.getId()){
                view.displayBudget(candidateBudget);
            }
        }
    }
}
