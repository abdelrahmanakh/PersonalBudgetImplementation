import java.util.List;
/**
 * Controller class responsible for managing and displaying budget entities.
 * Extends the AbstractController class to handle operations for Budget entities.
 * Part of the MVC design pattern
 */
public class IncomeController extends AbstractController<Income> {
    IncomeView view;

    /**
     * Constructs a new IncomeController.
     * @param incomes The list of income entities to be managed by the controller.
     * @param view The IncomeView used to display Income entities.
     */
    public IncomeController(List<Income> incomes, IncomeView view) {
        super(incomes);
        this.view = view;
    }

    /**
     * Displays the target Income entity by matching its ID with those in the list of entities.
     * If a match is found, the corresponding Income entity is displayed using the provided IncomeView.
     * @param targetIncome The Income entity to be displayed.
     */
    @Override
    public void displayEntity(Income targetIncome) {
        for (Income candidateIncome:getEntities()) {
            if(candidateIncome.getId() == targetIncome.getId()){
                view.displayIncome(candidateIncome);
            }
        }
    }
}
