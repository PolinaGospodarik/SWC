package model.entity;

public class Helmet extends Ammunition {


    public Helmet(String name, String material, double weight, double price) {
        super(name, material, weight, price, "Helmet");

    }

    @Override
    public String toString() {

       return "Тип: Helmet"+super.toString();
    }
}
