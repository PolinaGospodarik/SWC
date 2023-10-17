package main.java.entity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Sword")
public class Sword extends Ammunition {
    private static final List<String> names = new ArrayList<>(Arrays.asList(
            "Гвинтолео",
            "Кардуи",
            "Котелок",
            "Мастерский Котелок",
            "Серебряное Окончание",
            "Посейдон",
            "Зеркало Титанов",
            "Грозный Рог",
            "Белый Волк",
            "Эльфийская Сова"));

    private static final List<String> materials = new ArrayList<>(Arrays.asList(
            "Драконья кость",
            "Эльфийская сталь",
            "Черный оникс",
            "Магическая эссенция",
            "Обсидиановый слиток",
            "Серебряный арканит",
            "Волшебный кристалл",
            "Адамантитовая руда",
            "Великанская кожа"));

    private static final List<Double> weights = new ArrayList<Double>(Arrays.asList(
            1.2,
            1.5,
            2.0,
            2.1,
            1.9,
            2.5,
            2.8,
            3.2,
            2.7,
            2.4));

    private static final List<Double> prices = new ArrayList<Double>(Arrays.asList(
            500.0,
            600.0,
            800.0,
            850.0,
            750.0,
            900.0,
            1100.0,
            1200.0,
            1000.0,
            950.0));
    public Sword(String name, String material, double weight, double price) {
        super(name, material, weight, price, "Sword");
        Counter.addS();
    }

    public Sword()
    {
        super();
        Random random = new Random();
        int result = random.nextInt(0, names.size() - 1);
        this.setName(names.get(result));
        this.setMaterial(materials.get(result));
        this.setWeight(weights.get(result));
        this.setPrice(prices.get(result));
        this.setType("Sword");
        Counter.addS();
    }

    @Override
    public String toString() {
        return  "Тип: Sword"+super.toString() ;
    }
}
