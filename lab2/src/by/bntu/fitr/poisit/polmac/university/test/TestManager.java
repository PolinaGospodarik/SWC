package by.bntu.fitr.poisit.polmac.university.test;

import by.bntu.fitr.poisit.polmac.university.model.entity.Ammunition;
import by.bntu.fitr.poisit.polmac.university.model.entity.Sword;
import by.bntu.fitr.poisit.polmac.university.model.entity.Helmet;
import by.bntu.fitr.poisit.polmac.university.model.entity.Chestplate;
import by.bntu.fitr.poisit.polmac.university.model.logic.Manager;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TestManager {
    @org.junit.Test
    public void TestAdding(){
        Manager.ClearList();

        Ammunition sword = new Sword("Iron sword", "Iron", 20, 200);
        Ammunition helmet = new Helmet("Steel helmet", "Steel", 10, 150);
        Ammunition chestplate = new Chestplate("Kevlar chestplate", "Kevlar", 30, 300);

        List<Ammunition> excepted = new ArrayList<>();
        excepted.add(sword);
        excepted.add(helmet);
        excepted.add(chestplate);

        Manager.Add(sword);
        Manager.Add(helmet);
        Manager.Add(chestplate);

        List<Ammunition> actual = Manager.getList();

        Assert.assertEquals(excepted, actual);
    }

    @org.junit.Test
    public void TestSum(){
        Manager.ClearList();

        Ammunition sword = new Sword("Iron sword", "Iron", 20, 200);
        Ammunition helmet = new Helmet("Steel helmet", "Steel", 10, 150);
        Ammunition chestplate = new Chestplate("Kevlar chestplate", "Kevlar", 30, 300);

        double excepted = 650;

        Manager.Add(sword);
        Manager.Add(helmet);
        Manager.Add(chestplate);

        double actual = Manager.Sum();

        Assert.assertEquals(excepted, actual, 0.1);
    }

    @org.junit.Test
    public void TestMaxPrice(){
        Manager.ClearList();

        Ammunition sword = new Sword("Iron sword", "Iron", 20, 200);
        Ammunition helmet = new Helmet("Steel helmet", "Steel", 10, 150);
        Ammunition chestplate = new Chestplate("Kevlar chestplate", "Kevlar", 30, 300);

        Manager.Add(sword);
        Manager.Add(helmet);
        Manager.Add(chestplate);

        Ammunition actual = Manager.MaxPrice();

        Assert.assertEquals(chestplate, actual);
    }
}
