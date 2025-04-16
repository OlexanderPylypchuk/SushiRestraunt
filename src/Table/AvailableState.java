package Table;

public class AvailableState implements TableState {
    @Override
    public void next(Table context) {
        context.setState(new ReservedState());
    }

    @Override
    public String getStatus() {
        return "Available";
    }
}
