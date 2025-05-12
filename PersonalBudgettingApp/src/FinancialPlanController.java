public class FinancialPlanController extends AbstractController<FinancialPlan> {
    FinancialPlanView view;
    public FinancialPlanController(){
        super();
        this.view = new FinancialPlanView();
    }
    @Override
    public void displayEntity(FinancialPlan targetPlan) {
        for (FinancialPlan candidatePlan : getEntities()){
            if (candidatePlan.getId() == targetPlan.getId()){
                view.displayEntity(targetPlan);
            }
        }
    }
}
