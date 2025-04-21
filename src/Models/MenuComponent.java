package Models;

import Models.Interface.MenuItemPrototype;


public abstract class MenuComponent implements MenuItemPrototype {
    protected int id;
    private static int counter = 0;

    public MenuComponent() {
        this.id = counter++;
    }

    public int getId() {
        return id;
    }

    // Default implementations that Composite will override
    public void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(int id) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent find(int id) {
        throw new UnsupportedOperationException();
    }

    public abstract void display();
}
