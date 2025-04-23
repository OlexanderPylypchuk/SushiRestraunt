package Components;

import Models.Interface.Mediator;

public class Kitchen extends Component {
    public Kitchen(Mediator mediator) {
        super(mediator);
    }

    public void prepareOrder() {
        System.out.println("[Kitchen] Order is prepared.");
        mediator.notify(this, "prepared");
    }
}
