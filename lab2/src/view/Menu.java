package view;

import model.logic.Manager;
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
            int result = in.nextInt();
            if (result == 1) {
                Manager.Add(Creator.Create());
            } else if (result == 2) {
                Manager.Print();
            } else if (result == 3) {
                Manager.Sum();
            } else {
                Manager.MaxPrice();
            }
        }
    }
}