package university.view;

import university.model.logic.Manager;
import university.model.logic.Sorter;
import university.util.Creator;

import java.util.Scanner;

public class Menu {
    public static void ShowMenu() {
        Scanner in = new Scanner(System.in);
        int result = 1;
        while (result != 0) {
            System.out.println("Выберите действие");
            System.out.println("1. Добавить");
            System.out.println("2. Вывести");
            System.out.println("3. Сумма цен");
            System.out.println("4. Самая дорогая");
            System.out.println("5. Вывод по возрастанию цены");
            System.out.println("6. Вывод по убыванию цены");
            System.out.println("7. Отсортировать по типу аммуници");
            result = in.nextInt();

            switch (result) {
                case 1 -> Manager.Add(Creator.Create("1", "1","1",1,1));
                case 2 -> System.out.println(Printer.printAll());
                case 3 -> {
                    System.out.println("Общая сумма =" + Manager.Sum());
                }
                case 4 -> {
                    System.out.println(Manager.MaxPrice().toString());
                }
                case 5 -> {
                    Sorter.bubbleSorterUp();
                    Printer.printAll();
                }
                case 6 -> {
                    Sorter.bubbleSorterDown();
                    Printer.printAll();
                }
                case 7 -> {
                    System.out.println("1.Helmets \n 2.Chesplates \n 3.Swords");
                    int b = in.nextInt();
                    switch (b) {
                        case 1 -> {
                            Printer.printAll(Sorter.getHelmets());
                        }
                        case 2 -> {
                            Printer.printAll(Sorter.getChestplates());
                        }
                        case 3 -> {
                            Printer.printAll(Sorter.getSwords());
                        }
                    }
                }
                default -> System.out.println("Действе не распознано");
            }
        }
    }
}


