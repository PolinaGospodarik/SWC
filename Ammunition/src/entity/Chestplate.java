package entity;


public class Chestplate extends Ammunition {
    public Chestplate(String name, String material, double weight, double price ) {
        super(name, material, weight, price, "Chestplate");
        Counter.addC();
    }

    @Override
    public String toString() {
        return "Тип: Chestplate"+super.toString();
    }
}
