package view;

import model.entity.Ammunition;
import model.logic.Manager;

import javax.sound.midi.Soundbank;

public class Printer {
    public static void printInfo(Ammunition ammunition)
    {
        System.out.println(ammunition.toString());
    }

    public static void printAll()
    {
        for (Ammunition ammunition: Manager.list)
        {
            printInfo(ammunition);
        }
    }
}
