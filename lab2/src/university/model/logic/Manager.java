package university.model.logic;

import university.model.entity.Ammunition;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static final List<Ammunition> list = new ArrayList<Ammunition>();

    public static void Add(Ammunition ammunition) {
        if (ammunition == null)
            return;
        getList().add(ammunition);
    }

    public static double Sum() {
        double sum = 0;
        for (Ammunition ammunition : getList()) {
            sum += ammunition.getPrice();
        }
        return sum;
    }

    public static Ammunition MaxPrice() {
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
