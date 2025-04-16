package Components;

import Models.Interface.OrderMediator;

public class Delivery extends Component {
    public Delivery(OrderMediator mediator) {
        super(mediator);
    }

    public void deliverOrder() {
        System.out.println("[Delivery] Delivering order...");
        mediator.notify(this, "delivered");
    }
}
