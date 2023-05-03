package model.logic;

import model.entity.Ammunition;
import model.entity.Counter;
import view.Printer;

import java.util.Objects;

public class Sorter {
    private static void toSwap(int first, int second){
        Ammunition dummy = Manager.list.get(first);
        Manager.list.set(first,Manager.list.get(second));
        Manager.list.set(second,dummy);
    }

    public static void bubbleSorterUp(){
        for (int out = Manager.list.size()-1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(Manager.list.get(in).getPrice() > Manager.list.get(in+1).getPrice())
                    toSwap(in, in + 1);
            }
        }

        Printer.printAll();
    }

    public static void bubbleSorterDown(){
        for (int out = Manager.list.size()-1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(Manager.list.get(in).getPrice() < Manager.list.get(in+1).getPrice())
                    toSwap(in, in + 1);
            }
        }
        Printer.printAll();
    }
    public static void printHelmets()
    {
        if (Counter.getHelmets() != 0) {
            for (Ammunition ammunition : Manager.list) {
                if (Objects.equals(ammunition.getType(), "Helmet"))
                    Printer.printInfo(ammunition);
            }
        }
        else System.out.println("Данный тип отсутсвует");
    }

    public static void printChestplate()
    {
        if (Counter.getChestplates() != 0) {
            for (Ammunition ammunition : Manager.list) {
                if (Objects.equals(ammunition.getType(), "Chestplate"))
                    Printer.printInfo(ammunition);

            }
        }
        else System.out.println("Данный тип отсутсвует");
    }

    public static void printSword()
    {
        if (Counter.getSwords() != 0) {
            for (Ammunition ammunition : Manager.list) {
                if (Objects.equals(ammunition.getType(), "Sword"))
                    Printer.printInfo(ammunition);

            }
        }
        else System.out.println("Данный тип отсутсвует");
    }
}
