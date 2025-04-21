package Builders;
import Builders.Interfaces.IMenuItemBuilder;

public class SushiDirector {
    public void makePhiladelphiaSushi(IMenuItemBuilder builder){
        builder.setName("Philadelphia");
        builder.setPrice(150.0);
    }

    public void makeCaliforniaSushi(IMenuItemBuilder builder){
        builder.setName("California");
        builder.setPrice(160.0);
    }
}
