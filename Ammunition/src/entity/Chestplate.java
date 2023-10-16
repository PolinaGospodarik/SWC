package entity;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Chestplate extends Ammunition {

    private static final List<String> names = new ArrayList<>(Arrays.asList(
            "Грифоновый герб",
            "Ведьмачье мастерство",
            "Шепот леса", "Огненные крылья",
            "Око Земли",
            "Белый волк",
            "Сердце Скеллиге",
            "Змеиная шкура",
            "Львиный лов",
            "Золотое слезное ожерелье"));

    private static final List<String> materials = new ArrayList<>(Arrays.asList(
            "Кожа грифона",
            "Специальная металлическая смесь",
            "Кожа лесного чудища",
            "Драконья кожа",
            "Кожа",
            "Кожа волка",
            "Кожа морского чудища",
            "Кожа змеи",
            "Кожа льва"));

    private static final List<Double> weights = new ArrayList<Double>(Arrays.asList(
            3.5,
            3.1,
            5.2,
            4.7,
            3.9,
            4.3,
            5.8,
            4.0,
            4.6));

    private static final List<Double> prices = new ArrayList<Double>(Arrays.asList(
            750.0,
            500.0,
            1200.0,
            1500.0,
            900.0,
            1000.0,
            1800.0,
            950.0,
            1100.0));

    public Chestplate(String name, String material, double weight, double price ) {
        super(name, material, weight, price, "Chestplate");
        Counter.addC();
    }

    public Chestplate()
    {
        super();
        Random random = new Random();
        int result = random.nextInt(0, names.size() - 1);
        this.setName(names.get(result));
        this.setMaterial(materials.get(result));
        this.setWeight(weights.get(result));
        this.setPrice(prices.get(result));
        this.setType("Chestplate");
        Counter.addC();
    }

    @Override
    public String toString() {
        return "Тип: Chestplate"+super.toString();
    }
}
