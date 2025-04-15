package Models;

import Models.Interface.MenuItemPrototype;

import java.util.ArrayList;
import java.util.List;

public class MenuGroup extends MenuComponent {
    private String name;
    private List<MenuComponent> items = new ArrayList<>();

    public MenuGroup(String name) {
        this.name = name;
    }

    @Override
    public void add(MenuComponent component) {
        items.add(component);
    }

    @Override
    public void display() {
        System.out.println("\n" + name);
        for (MenuComponent component : items) {
            component.display();
        }
    }

    @Override
    public MenuItemPrototype clone() {
        MenuGroup clonedGroup = new MenuGroup(this.name + " (Clone)");
        for (MenuComponent item : items) {
            clonedGroup.add((MenuComponent) item.clone());
        }
        return clonedGroup;
    }
}