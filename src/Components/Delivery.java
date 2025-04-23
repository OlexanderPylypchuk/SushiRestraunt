package Components;

import Models.Interface.Mediator;

public class Delivery extends Component {
    public Delivery(Mediator mediator) {
        super(mediator);
    }

    public void deliverOrder() {
        System.out.println("[Delivery] Delivering order...");
        mediator.notify(this, "delivered");
    }
}
