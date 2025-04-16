package Table;

public class Table {
    private TableState state;

    public Table() {
        this.state = new AvailableState(); // default state
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
