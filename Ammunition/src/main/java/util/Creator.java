package main.java.util;

import main.java.entity.Ammunition;
import main.java.entity.Chestplate;
import main.java.entity.Helmet;
import main.java.entity.Sword;

import java.util.Objects;
import java.util.Scanner;

import static main.java.util.Logger.getLogg;


public class Creator {
    public static Ammunition Create() {
        org.apache.logging.log4j.Logger logger = getLogg();
        logger.info("Try creating an object form console");
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
            logger.info("Created chestplate");
            return new Chestplate(name, material, weight, price);
        } else if (Objects.equals(type, "Sword")) {
            logger.info("Created sword");
            return new Sword(name, material, weight, price);
        } else {
            logger.info("Created helmet");
            return new Helmet(name, material, weight, price);
        }
    }

    public static Ammunition Create(String type, String name, String material, double weight, double price)
    {
        org.apache.logging.log4j.Logger logger = getLogg();
        logger.info("Try creating an object form GUI");

        if (Objects.equals(type, "Chestplate")) {
            logger.info("Created chestplate");
            return new Chestplate(name, material, weight, price);
        } else if (Objects.equals(type, "Sword")) {
            logger.info("Created sword");
            return new Sword(name, material, weight, price);
        } else {
            logger.info("Created helmet");
            return new Helmet(name, material, weight, price);
        }
    }

    public static Ammunition Create(String type)
    {
        org.apache.logging.log4j.Logger logger = getLogg();
        logger.info("Try creating a random object");


        if (Objects.equals(type, "Chestplate")) {
            logger.info("Created chestplate");
            return new Chestplate();
        } else if (Objects.equals(type, "Sword")) {
            logger.info("Created sword");
            return new Sword();
        } else {
            logger.info("Created helmet");
            return new Helmet();
        }
    }

}