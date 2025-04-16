package SushiMaking;

import Models.SushiItem;

public class FishCutter extends SushiPreparationStep {
    @Override
    public void handle(SushiItem sushi) {
        System.out.println("Cutting fish for: " + sushi.GetName());
        if (nextStep != null) nextStep.handle(sushi);
    }
}