package Models.Interface;

import java.util.List;

public interface RestaurantFacade {
    void addMenuItemToOrder(String itemName);
    void addMenuItemWithAddons(String itemName, List<String> addons);
    void completeOrder();
}
