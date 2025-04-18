package Models;

import Models.Interface.MenuItemPrototype;
import Models.Interface.OrderItem;
import Models.Interface.RestaurantFacade;
import com.sun.tools.jconsole.JConsoleContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantFacadeImpl implements RestaurantFacade {
    private Order order;
    private Map<String, MenuItemPrototype> menu;

    public RestaurantFacadeImpl() {
        this.order = new Order();
        this.menu = new HashMap<>();

        // Setup menu (in real app, this might come from DB or file)
        menu.put("Salmon Roll", new MenuItem("Salmon Roll", 100));
        menu.put("Tuna Roll", new MenuItem("Tuna Roll", 120));
        menu.put("Philadelphia Roll", new MenuItem("Philadelphia Roll", 130));
    }

    @Override
    public void addMenuItemToOrder(String itemName) {
        MenuItemPrototype prototype = menu.get(itemName);
        if (prototype != null) {
            order.addItem((OrderItem) prototype.clone());
        }
    }

    @Override
    public void addMenuItemWithAddons(String itemName, List<String> addons) {
        MenuItemPrototype prototype = menu.get(itemName);
        if (prototype != null) {
            OrderItem base = new BasicOrderItem(itemName, ((MenuItem) prototype).getPrice());
            for (String addon : addons) {
                switch (addon.toLowerCase()) {
                    case "extra wasabi":
                        base = new ExtraWasabiDecorator(base);
                        break;
                }
            }
            order.addItem(base);
        }
    }

    @Override
    public void completeOrder() {
        double total = order.calculateTotal();
        System.out.println(order.getOrderId() + " complete order price = " + total);
    }
}