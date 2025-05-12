public class Income extends FinancialEntry{
    private String source;
    public Income(int id, int amount, String title, String source, boolean isRecurring) {
        super(id, amount, title, isRecurring);
        this.source = source;
    }
    public String getSource() {
        return source;
    }
    public void updateSource(String source) {
        this.source = source;
    }
}
