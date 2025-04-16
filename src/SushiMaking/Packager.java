package SushiMaking;

import Models.SushiItem;

public class Packager extends SushiPreparationStep {
    @Override
    public void handle(SushiItem sushi) {
        System.out.println("Packaging sushi: " + sushi.GetName());
    }
}
