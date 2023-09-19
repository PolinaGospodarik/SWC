package main.view;

import main.model.entity.Ammunition;
import main.model.logic.Manager;

import java.util.List;

public class Printer {
    public static void printInfo(Ammunition ammunition)
    {
        System.out.println(ammunition.toString());
    }

    public static void printAll()
    {
        for (Ammunition ammunition: Manager.getList())
        {
            printInfo(ammunition);
        }
    }

    public static void printAll(List<Ammunition> list)
    {
        if(list.isEmpty()){
            System.out.println("Пусто!");
            return;
        }
        for (Ammunition ammunition: list)
        {
            printInfo(ammunition);
        }
    }
}
