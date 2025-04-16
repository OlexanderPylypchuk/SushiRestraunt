package Components;

import Models.Interface.OrderMediator;

public class Kitchen extends Component {
    public Kitchen(OrderMediator mediator) {
        super(mediator);
    }

    public void prepareOrder() {
        System.out.println("[Kitchen] Order is prepared.");
        mediator.notify(this, "prepared");
    }
}
