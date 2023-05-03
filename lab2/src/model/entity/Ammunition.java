package model.entity;


public abstract class Ammunition {
    private String name;
    private String material;
    private double weight;
    private double price;
    private String type;

    public Ammunition() {
        this.name = "Дубина переговоров";
        this.material = "Металл";
        this.weight = 10;
        this.price = 1096543456;

    }

    public Ammunition(String name, String material, double weight, double price, String type) {
        this.setName(name);
        this.setMaterial(material);
        this.setWeight(weight);
        this.setPrice(price);
        this.setType(type);
    }

    public Ammunition(Ammunition ammunition) {
        this.name = ammunition.name;
        this.material = ammunition.material;
        this.weight = ammunition.weight;
        this.price = ammunition.price;
        this.type = ammunition.type;
        Counter.addT();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "\n Наименование: " + getName() + "\n Материал:  " + getMaterial() + "\n Вес:  " + getWeight() + "\n Цена:  " + getPrice();
    }

}
