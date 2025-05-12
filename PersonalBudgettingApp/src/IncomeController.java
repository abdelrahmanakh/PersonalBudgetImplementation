import java.util.List;

public class IncomeController extends AbstractController<Income> {
    IncomeView view;
    public IncomeController(List<Income> entities, IncomeView view) {
        super(entities);
        this.view = view;
    }

    @Override
    public void displayEntity(Income taregetIncome) {
        for (Income candidateIncome:getEntities()) {
            if(candidateIncome.getId() == taregetIncome.getId()){
                view.displayIncome(candidateIncome);
            }
        }
    }
}
