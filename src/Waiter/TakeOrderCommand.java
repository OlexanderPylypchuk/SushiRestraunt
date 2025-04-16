package Waiter;

import Waiter.Interface.WaiterCommand;

public class TakeOrderCommand implements WaiterCommand {
    private final Waiter waiter;

    public TakeOrderCommand(Waiter waiter) {
        this.waiter = waiter;
    }

    @Override
    public void execute() {
        waiter.takeOrder();
    }
}
