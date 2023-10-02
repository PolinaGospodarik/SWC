package university.model.logic;

import university.model.entity.Ammunition;
import university.model.entity.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sorter {
    private static void toSwap(int first, int second){
        Ammunition dummy = Manager.getList().get(first);
        Manager.getList().set(first, Manager.getList().get(second));
        Manager.getList().set(second,dummy);
    }

    public static void bubbleSorterUp(){
        for (int out = Manager.getList().size()-1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(Manager.getList().get(in).getPrice() > Manager.getList().get(in+1).getPrice())
                    toSwap(in, in + 1);
            }
        }
    }

    public static void bubbleSorterDown(){
        for (int out = Manager.getList().size()-1; out >= 1; out--){
            for (int in = 0; in < out; in++){
                if(Manager.getList().get(in).getPrice() < Manager.getList().get(in+1).getPrice())
                    toSwap(in, in + 1);
            }
        }
    }
    public static List<Ammunition> getHelmets()
    {
        if (Counter.getHelmets() != 0) {
            List<Ammunition> list = new ArrayList<Ammunition>();
            for (Ammunition ammunition : Manager.getList()) {
                if (Objects.equals(ammunition.getType(), "Helmet"))
                    list.add(ammunition);
            }
            return list;
        }
        else return null;
    }

    public static List<Ammunition> getChestplates()
    {
        if (Counter.getChestplates() != 0) {
            List<Ammunition> list = new ArrayList<Ammunition>();
            for (Ammunition ammunition : Manager.getList()) {
                if (Objects.equals(ammunition.getType(), "Chestplate"))
                    list.add(ammunition);
            }
            return list;
        }
        else return null;
    }

    public static List<Ammunition> getSwords()
    {
        if (Counter.getSwords() != 0) {
            List<Ammunition> list = new ArrayList<Ammunition>();
            for (Ammunition ammunition : Manager.getList()) {
                if (Objects.equals(ammunition.getType(), "Sword"))
                    list.add(ammunition);
            }
            return list;
        }
        else return null;
    }
}
