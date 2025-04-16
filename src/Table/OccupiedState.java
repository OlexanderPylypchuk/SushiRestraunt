package Table;

public class OccupiedState implements TableState {
    @Override
    public void next(Table context) {
        context.setState(new NeedsCleaningState());
    }

    @Override
    public String getStatus() {
        return "Occupied";
    }
}
