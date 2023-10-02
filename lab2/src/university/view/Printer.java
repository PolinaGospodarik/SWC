package university.view;

import university.model.entity.Ammunition;
import university.model.logic.Manager;

import java.util.List;

public class Printer {
    public static String printInfo(Ammunition ammunition)
    {
        return ammunition.toString()+"\n" ;
    }

    public static String printAll()
    {
        String text = "";
        for (Ammunition ammunition: Manager.getList())
        {
            text+=printInfo(ammunition);
        }

        return text;
    }

    public static String printAll(List<Ammunition> list)
    {
        if(list.isEmpty()){
            return "Пусто!";
        }
        StringBuilder text = new StringBuilder();
        for (Ammunition ammunition: list)
        {
            text.append(printInfo(ammunition));
        }

        return text.toString();
    }
}
