package Waiter;

import Waiter.Interface.WaiterCommand;

public class GreetCommand implements WaiterCommand {
    private final Waiter waiter;

    public GreetCommand(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void execute() {
        waiter.greet();
    }
}

