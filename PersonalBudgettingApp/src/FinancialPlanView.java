public class FinancialPlanView {
    public void displayEntity(FinancialPlan plan) {
        System.out.println("ID: " + plan.getId());
        System.out.println("Title: " + plan.getTitle());
        System.out.println("Total Amount: " + plan.getTotalAmount());
        System.out.println("Due Date: " + plan.getDueDate());
    }
}
