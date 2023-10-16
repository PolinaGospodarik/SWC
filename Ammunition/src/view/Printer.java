package view;


import entity.Ammunition;
import logic.Manager;

import javax.swing.*;
import java.io.*;
import java.util.List;

public class Printer {
    public static String printInfo(Ammunition ammunition) {
        return ammunition.toString() + "\n";
    }

    public static String printInfo() {
        if (Manager.getList() == null)
            return "Пусто";
        String text = "";
        for (Ammunition ammunition : Manager.getList()) {
            text += "— " + printInfo(ammunition) + "\n";
        }

        return text;
    }

    public static String printInfo(List<Ammunition> list) {
        if (list == null | (list != null && list.isEmpty())) {
            return "Пусто!";
        }
        String text = "";
        for (Ammunition ammunition : list) {
            text += "— " + printInfo(ammunition) + "\n";
        }

        return text;
    }

    public static String serialize(List<Ammunition> list) {
        StringBuilder result = new StringBuilder();
        for (Ammunition ammunition : list) {
            result.append(serialize(ammunition));
        }

        return result.toString();
    }

    public static String serialize(Ammunition ammunition) {
        return "[" + ammunition.getType() + "," + ammunition.getName() + "," + ammunition.getMaterial() + "," +
                ammunition.getWeight() + "," + ammunition.getPrice() + "]";
    }



}
