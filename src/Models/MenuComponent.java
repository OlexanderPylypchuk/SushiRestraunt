package Models;

import Models.Interface.MenuItemPrototype;

public abstract class MenuComponent implements MenuItemPrototype {
    protected int id;
    private static int Counter = 0;
    public MenuComponent(){
        this.id = Counter++;
    }
    public int getId(){
        return id;
    }

    public void add(MenuComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(int id) {
        throw new UnsupportedOperationException();
    }

    public abstract void display();
    public abstract MenuItemPrototype clone();

    public MenuComponent find(int id) {
        throw new UnsupportedOperationException();
    }
}
