package util;
import java.util.Scanner;
import model.entity.Ammunition;
import model.entity.Chestplate;
import model.entity.Helmet;
import model.entity.Sword;

public class Creator {
    public static Ammunition Create() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите тип:\n 1.Helmet\n 2.Chesplate\n 3.Sword\n");
        int a= in.nextInt();
        switch (a){
            case 1:
                System.out.println("Helmet");
                break;
            case 2:
                System.out.println("Chesplate");
                break;
            case 3:
                System.out.println("Sword");
                break;
        }
        String type = in.nextLine();
        System.out.println("Введите название: ");
        String name = in.nextLine();
        System.out.println("Введите материал: ");
        String material = in.nextLine();
        System.out.println("Введите размер: ");
        double weight = in.nextDouble();
        System.out.println("Введите цену: ");
        double price = in.nextDouble();
        if (type == "Chesplate") {
            return new Chestplate(name, material, weight, price);
        } else if (type == "Sword") {
            return new Sword(name, material, weight, price);
        } else {
            return new Helmet(name, material, weight, price);
        }
    }
}