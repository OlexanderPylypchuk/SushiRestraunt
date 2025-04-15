package Models;

import Models.Interface.MenuItemPrototype;

public class MenuItem extends MenuComponent {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void display() {
        System.out.println(name + " : " + price + " UAH");
    }

    @Override
    public MenuItemPrototype clone() {
        return new MenuItem(this.name, this.price);
    }
}