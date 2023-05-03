package model.entity;

public class Counter {
    private static int total;
    private static int helmets;
    private static int chestplates;
    private static int swords;

    {
        total = 0;
        helmets = 0;
        chestplates = 0;
        swords = 0;
    }

    static void addT() {
        total = getTotal() + 1;
    }

    static void removeT() {
        total = getTotal() - 1;
    }

    static void addH() {
        helmets = getHelmets() + 1;
    }

    static void removeH() {
        helmets = getHelmets() - 1;
    }

   static void addC() {
        chestplates = getChestplates() + 1;
    }
    static void removeC() {
        chestplates = getChestplates() - 1;
    }
    static void addS() {
        swords = getSwords() + 1;
    }
    static void removeS() {
        swords = getSwords() - 1;
    }



    public static int getTotal() {
        return total;
    }

    public static int getHelmets() {
        return helmets;
    }

    public static int getChestplates() {
        return chestplates;
    }

    public static int getSwords() {
        return swords;
    }
}
