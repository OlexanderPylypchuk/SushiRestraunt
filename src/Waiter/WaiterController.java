package Waiter;

import Waiter.Interface.WaiterCommand;

import java.util.ArrayList;
import java.util.List;

public class WaiterController {
    private final List<WaiterCommand> queue = new ArrayList<>();

    public void addCommand(WaiterCommand command) {
        queue.add(command);
    }

    public void runCommands() {
        for (WaiterCommand command : queue) {
            command.execute();
        }
        queue.clear();
    }
}