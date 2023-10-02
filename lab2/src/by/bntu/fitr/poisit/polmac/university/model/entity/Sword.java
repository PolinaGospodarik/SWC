package by.bntu.fitr.poisit.polmac.university.model.entity;


public class Sword extends Ammunition {

    public Sword(String name, String material, double weight, double price) {
        super(name, material, weight, price, "Sword");
        Counter.addS();
    }

    @Override
    public String toString() {
        return  "Тип: Sword"+super.toString() ;
    }
}
