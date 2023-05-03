package view;

import model.logic.Manager;
import model.logic.Sorter;
import util.Creator;

import java.util.Scanner;
public class Menu {
    public static void ShowMenu() {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие");
            System.out.println("1. Добавить");
            System.out.println("2. Вывести");
            System.out.println("3. Сумма цен");
            System.out.println("4. Самая дорогая");
            System.out.println("5. Вывод по возрастанию");
            System.out.println("6. Вывод по убыванию");
            System.out.println("7. Вывести тип оружия");
            int result = in.nextInt();
            if (result == 1)
                Manager.Add(Creator.Create());
            else if (result == 2)
                Printer.printAll();
            else if (result == 3)
                Manager.Sum();
            else if (result == 4)
                Manager.MaxPrice();
            else if (result==5)
                Sorter.bubbleSorterUp();
            else if (result==6)
                Sorter.bubbleSorterDown();
            else {
                System.out.println("1.Helmets \n 2.Chesplates \n 3.Swords");
                int b= in.nextInt();
                switch (b){
                    case 1:
                        Sorter.printHelmets();
                        break;
                    case 2:
                        Sorter.printChestplate();
                        break;
                    case 3:
                        Sorter.printSword();
                        break;
                }
            }
        }
    }
}


