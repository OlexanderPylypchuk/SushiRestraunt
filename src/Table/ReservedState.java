package Table;

public class ReservedState implements TableState {
    @Override
    public void next(Table context) {
        context.setState(new OccupiedState());
    }

    @Override
    public String getStatus() {
        return "Reserved";
    }
}
