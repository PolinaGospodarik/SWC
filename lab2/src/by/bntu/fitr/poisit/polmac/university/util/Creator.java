package by.bntu.fitr.poisit.polmac.university.util;
import java.util.Objects;
import java.util.Scanner;
import by.bntu.fitr.poisit.polmac.university.model.entity.Ammunition;
import by.bntu.fitr.poisit.polmac.university.model.entity.Sword;
import by.bntu.fitr.poisit.polmac.university.model.entity.Helmet;
import by.bntu.fitr.poisit.polmac.university.model.entity.Chestplate;

public class Creator {
    public static Ammunition Create() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите тип:\n 1.Helmet\n 2.Chesplate\n 3.Sword");
        int a= in.nextInt();
        String type = "";
        switch (a) {
            case 1 -> type = "Helmet";
            case 2 -> type = "Chestplate";
            case 3 -> type = "Sword";
            default -> {
                System.out.println("Ошибка ввода");
                return null;
            }
        }
        in.nextLine();
        System.out.println("Введите название: ");
        String name = in.nextLine();
        System.out.println("Введите материал: ");
        String material = in.nextLine();

        double weight;
        double price;
        try {
            System.out.println("Введите размер: ");
            weight = in.nextDouble();
            System.out.println("Введите цену: ");
            price = in.nextDouble();
        }
        catch (Exception exception)
        {
            System.out.println("Ошибка ввода");
            return null;
        }

        if (Objects.equals(type, "Chestplate")) {
            return new Chestplate(name, material, weight, price);
        } else if (Objects.equals(type, "Sword")) {
            return new Sword(name, material, weight, price);
        } else {
            return new Helmet(name, material, weight, price);
        }
    }

    public static Ammunition Create(String type, String name, String material, double weight, double price)
    {
        if (Objects.equals(type, "Chestplate")) {
            return new Chestplate(name, material, weight, price);
        } else if (Objects.equals(type, "Sword")) {
            return new Sword(name, material, weight, price);
        } else {
            return new Helmet(name, material, weight, price);
        }
    }
}