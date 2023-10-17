package main.java.logic;



import main.java.entity.Ammunition;

import java.util.ArrayList;
import java.util.List;
import static main.java.util.Logger.getLogg;

public class Manager {
    private static final List<Ammunition> list = new ArrayList<Ammunition>();

    public static void Add(Ammunition ammunition) {
        org.apache.logging.log4j.Logger logger = getLogg();
        logger.info("Try to add object to list");

        if (ammunition == null) {
            logger.warn("Object is null");
            return;
        }
        logger.info("Successfully ");
        getList().add(ammunition);
    }

    public static double Sum() {
        org.apache.logging.log4j.Logger logger = getLogg();
        logger.info("Getting sum");

        double sum = 0;
        for (Ammunition ammunition : getList()) {
            sum += ammunition.getPrice();
        }
        return sum;
    }

    public static Ammunition MaxPrice() {
        org.apache.logging.log4j.Logger logger = getLogg();
        logger.info("Getting max price");

        Ammunition max = getList().get(0);
        for (Ammunition ammunition : getList()) {
            if (max.getPrice() < ammunition.getPrice()) {
                max = ammunition;
            }
        }
        return max;
    }

    public static List<Ammunition> getList() {
        return list;
    }

    public static void ClearList() {
        getList().clear();
    }
}
