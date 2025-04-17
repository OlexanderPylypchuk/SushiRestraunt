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
    public MenuComponent find(int id) {
        if (this.id == id) return this;
        for (MenuComponent component : items) {
            MenuComponent found = component.find(id);
            if (found != null) return found;
        }
        return null;
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < items.size(); i++) {
            MenuComponent component = items.get(i);
            if (component.getId() == id) {
                items.remove(i);
                return;
            } else if (component instanceof MenuGroup) {
                component.remove(id);
            }
        }
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