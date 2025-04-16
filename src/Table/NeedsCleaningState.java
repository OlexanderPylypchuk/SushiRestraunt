package Table;

public class NeedsCleaningState implements TableState {
    @Override
    public void next(Table context) {
        context.setState(new AvailableState());
    }

    @Override
    public String getStatus() {
        return "Needs Cleaning";
    }
}
