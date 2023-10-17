package main.java.entity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("Helmet")
public class Helmet extends Ammunition {

    private static final List<String> names = new ArrayList<>(Arrays.asList(
            "Гривна воина",
            "Маска Солнца",
            "Теневой Шлем",
            "Драконья Чешуя",
            "Шлем Ведьмака",
            "Лунная Маска",
            "Шлем Великана",
            "Око Грифона",
            "Шлем Повелителя",
            "Корона Ворона"));

    private static final List<String> materials = new ArrayList<>(Arrays.asList(
            "Специальный металл",
            "Золото",
            "Драконья кожа",
            "Ведьмачья кожа",
            "Эльфийская сталь",
            "Мифриль",
            "Адамантитовый слиток",
            "Черный магический металл",
            "Кристалл Ледяного Сердца",
            "Оникс"));

    private static final List<Double> weights = new ArrayList<Double>(Arrays.asList(
            1.1,
            1.3,
            1.5,
            1.8,
            1.2,
            1.4,
            1.7,
            1.9,
            1.6,
            2.0));

    private static final List<Double> prices = new ArrayList<Double>(Arrays.asList(
            400.0,
            450.0,
            550.0,
            600.0,
            480.0,
            520.0,
            620.0,
            700.0,
            650.0,
            750.0));
    public Helmet(String name, String material, double weight, double price) {
        super(name, material, weight, price, "Helmet");
        Counter.addH();
    }

    public Helmet()
    {
        super();
        Random random = new Random();
        int result = random.nextInt(0, names.size() - 1);
        this.setName(names.get(result));
        this.setMaterial(materials.get(result));
        this.setWeight(weights.get(result));
        this.setPrice(prices.get(result));
        this.setType("Chestplate");
        Counter.addH();
    }

    @Override
    public String toString() {

       return "Тип: Helmet"+super.toString();
    }
}
