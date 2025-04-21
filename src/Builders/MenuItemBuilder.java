package Builders;

import Builders.Interfaces.IMenuItemBuilder;
import Models.MenuItem;

public class MenuItemBuilder implements IMenuItemBuilder {
    private int Id = 0;
    public void reset(){
        Id = 0;
        Name = null;
        Price = 0;
    }
    public void setId(int id){
        Id=id;
    }
    public int GetId() {
        return Id;
    }
    private String Name = "";
    public void setName(String name){
        Name=name;
    }
    public String GetName() {
        return Name;
    }
    private double Price = 0;
    public double GetPrice(){
        return Price;
    }

    public void setPrice(double price){
        Price=price;
    }

    public MenuItem getResult() {
        return new MenuItem(this);
    }
}
