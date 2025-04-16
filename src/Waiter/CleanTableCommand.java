package Waiter;

import Waiter.Interface.WaiterCommand;

public class CleanTableCommand implements WaiterCommand {
    private final Waiter waiter;

    public CleanTableCommand(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void execute() {
        waiter.cleanTable();
    }
}
