package Models;

import Builders.SushiItemBuilder;
import Models.Interface.MenuItemPrototype;

public class SushiItem extends MenuItem {
    public SushiItem(){
        super("", 0);
    }
    private SushiItem(String name, double price, String ingridients){
        super(name, price);
        Name = name;
        Price = price;
        Ingridients = ingridients;
    }
    public SushiItem(SushiItemBuilder builder){
        super(builder.GetName(), builder.GetPrice());
        Name = builder.GetName();
        Price = builder.GetPrice();
        Ingridients = builder.GetIngridients();
    }
    private String Name;
    public String GetName(){
        return Name;
    }
    public void SetName(String name){
        Name=name;
    }
    private double Price;
    public double GetPrice(){
        return Price;
    }
    public void SetPrice(double price){
        Price=price;
    }
    private String Ingridients;
    public String GetIngridients(){
        return Ingridients;
    }
    public void SetIngridients(String ingridients){
        Ingridients=ingridients;
    }
    @Override
    public MenuItemPrototype clone() {
        return new SushiItem(Name, Price, Ingridients);
    }
}
