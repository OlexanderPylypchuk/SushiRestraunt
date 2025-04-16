package SushiMaking;

import Models.SushiItem;

public class RicePreparer extends SushiPreparationStep {
    @Override
    public void handle(SushiItem sushi) {
        System.out.println("Preparing rice for: " + sushi.GetName());
        if (nextStep != null) nextStep.handle(sushi);
    }
}