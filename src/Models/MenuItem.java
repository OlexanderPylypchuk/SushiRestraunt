package Models;

import Models.Interface.MenuItemPrototype;
import Visitor.Visitable;
import Visitor.Visitor;

public class MenuItem extends MenuComponent implements Visitable {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    @Override
    public void display() {
        System.out.println(name + " : " + price + " UAH");
    }

    @Override
    public MenuItemPrototype clone() {
        return new MenuItem(this.name, this.price);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}