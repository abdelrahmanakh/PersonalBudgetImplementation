public class FinancialPlanController extends AbstractController<FinancialPlan> {
    FinancialPlanView view;
    public FinancialPlanController(){
        this.view = new FinancialPlanView();
    }
    @Override
    public void displayEntity(int id) {
        for (FinancialPlan plan : getEntities()){
            if (plan.getId() == id){
                view.displayEntity(plan);
            }
        }
    }
}
