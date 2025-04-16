package SushiMaking;

import Models.SushiItem;

public abstract class SushiPreparationStep {
    protected SushiPreparationStep nextStep;

    public SushiPreparationStep setNext(SushiPreparationStep nextStep) {
        this.nextStep = nextStep;
        return nextStep;
    }

    public abstract void handle(SushiItem sushi);
}
