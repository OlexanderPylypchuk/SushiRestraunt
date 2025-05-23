package Waiter;

import Waiter.Interface.WaiterCommand;
import java.util.Stack;

public class WaiterInvoker {
    private final Stack<WaiterCommand> queue = new Stack<WaiterCommand>();

    public void addCommand(WaiterCommand command) {
        queue.add(command);
    }

    public void execute() {
        for (WaiterCommand command : queue) {
            command.execute();
        }
        queue.clear();
    }
}