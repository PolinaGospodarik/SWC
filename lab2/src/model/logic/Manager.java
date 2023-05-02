package model.logic;

import model.entity.Ammunition;

import java.util.ArrayList;
import java.util.List;

public class Manager {
    public static List<Ammunition> list = new ArrayList<Ammunition>();

    public static void Add(Ammunition ammunition) {
        list.add(ammunition);
    }

    public static void Print() {
        for(Ammunition ammunition : list) {
            System.out.println(ammunition.toString());
        }
    }
    public static void Sum() {
        double sum=0;
        for (Ammunition ammunition: list){
            sum+=ammunition.getPrice();
        }
        System.out.println("Общая сумма ="+sum);
    }
    public static void MaxPrice(){
       Ammunition max = list.get(0);
       for(Ammunition ammunition: list){
           if(max.getPrice()<ammunition.getPrice()){
               max=ammunition;
           }
       }
        System.out.println(max.toString());
    }
}
