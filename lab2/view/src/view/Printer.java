package view;


import logic.Manager;
import entity.Ammunition;
import java.util.List;

public class Printer {
    public static String printInfo(Ammunition ammunition)
    {
        return ammunition.toString()+"\n" ;
    }

    public static String printInfo()
    {

        String text = "";
        for (Ammunition ammunition: Manager.getList())
        {
            text+="— "+printInfo(ammunition)+"\n";
        }

        return text;
    }

    public static String printInfo(List<Ammunition> list)
    {
        if(list==null | (list != null && list.isEmpty())){
            return "Пусто!";
        }
        String text = "";
        for (Ammunition ammunition: list)
        {
            text+="— "+printInfo(ammunition)+"\n";
        }

        return text;
    }
}
