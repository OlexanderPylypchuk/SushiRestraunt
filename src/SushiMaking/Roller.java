package SushiMaking;

import Models.SushiItem;

public class Roller extends SushiPreparationStep {
    @Override
    public void handle(SushiItem sushi) {
        System.out.println("Rolling sushi: " + sushi.GetName());
        if (nextStep != null) nextStep.handle(sushi);
    }
}
