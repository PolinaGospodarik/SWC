package main.model.entity;


public class Helmet extends Ammunition {


    public Helmet(String name, String material, double weight, double price) {
        super(name, material, weight, price, "Helmet");
        Counter.addH();
    }

    @Override
    public String toString() {

       return "Тип: Helmet"+super.toString();
    }
}
