package Builders;

import Models.SushiItem;

public class SushiItemBuilder {
    private int Id = 0;
    public SushiItemBuilder SetId(int id){
        Id=id;
        return this;
    }
    public int GetId() {
        return Id;
    }
    private String Name = "";
    public SushiItemBuilder SetName(String name){
        Name=name;
        return this;
    }
    public String GetName() {
        return Name;
    }
    private double Price = 0;
    public double GetPrice(){
        return Price;
    }
    public SushiItemBuilder SetPrice(double price){
        Price=price;
        return this;
    }
    private String Ingridients = "";
    public String GetIngridients(){
        return Ingridients;
    }
    public SushiItemBuilder SetIngridients(String ingridients){
        Ingridients=ingridients;
        return this;
    }
    public SushiItem build() {
        return new SushiItem(this);
    }
}
