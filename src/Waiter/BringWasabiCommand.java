package Waiter;

import Waiter.Interface.WaiterCommand;

public class BringWasabiCommand implements WaiterCommand {
    private final Waiter waiter;

    public BringWasabiCommand(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void execute() {
        waiter.bringWasabi();
    }
}

