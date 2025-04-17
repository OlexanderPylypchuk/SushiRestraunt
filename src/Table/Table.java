package Table;

public class Table {
    private int number;
    private static int Counter = 0;
    private TableState state;

    public Table() {
        this.state = new AvailableState();
        number = Counter++;
    }

    public void setState(TableState state) {
        this.state = state;
    }

    public void advance() {
        state.next(this);
    }

    public String getStatus() {
        return state.getStatus();
    }
}
