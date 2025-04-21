package Builders;

import Builders.Interfaces.IMenuItemBuilder;
import Models.SushiItem;

public class SushiItemBuilder implements IMenuItemBuilder {
    private int Id = 0;
    public void reset(){
        Id = 0;
        Name = null;
        Price = 0;
        Ingridients = null;
    }
    public SushiItemBuilder SetId(int id){
        Id=id;
        return this;
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
    private String Ingridients = "";
    public String GetIngridients(){
        return Ingridients;
    }
    public void setIngridients(String ingridients){
        Ingridients=ingridients;
    }
    public SushiItem getResult() {
        return new SushiItem(this);
    }
}
