package test;

import main.model.entity.Ammunition;
import main.model.entity.Chestplate;
import main.model.entity.Helmet;
import main.model.entity.Sword;
import main.model.logic.Manager;
import main.model.logic.Sorter;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class TestSorter {
    @org.junit.Test
    public void TestSortUp(){
        Manager.ClearList();

        Ammunition sword = new Sword("Iron sword", "Iron", 20, 200);
        Ammunition helmet = new Helmet("Steel helmet", "Steel", 10, 150);
        Ammunition chestplate = new Chestplate("Kevlar chestplate", "Kevlar", 30, 300);

        List<Ammunition> excepted = new ArrayList<>();
        excepted.add(helmet);
        excepted.add(sword);
        excepted.add(chestplate);

        Manager.Add(sword);
        Manager.Add(helmet);
        Manager.Add(chestplate);

        Sorter.bubbleSorterUp();
        List<Ammunition> actual = Manager.getList();

        Assert.assertEquals(excepted.get(0), actual.get(0));
        Assert.assertEquals(excepted.get(1), actual.get(1));
        Assert.assertEquals(excepted.get(2), actual.get(2));
    }

    @org.junit.Test
    public void TestSortDown(){
        Manager.ClearList();

        Ammunition sword = new Sword("Iron sword", "Iron", 20, 200);
        Ammunition helmet = new Helmet("Steel helmet", "Steel", 10, 150);
        Ammunition chestplate = new Chestplate("Kevlar chestplate", "Kevlar", 30, 300);

        List<Ammunition> excepted = new ArrayList<>();
        excepted.add(chestplate);
        excepted.add(sword);
        excepted.add(helmet);

        Manager.Add(sword);
        Manager.Add(helmet);
        Manager.Add(chestplate);

        Sorter.bubbleSorterDown();
        List<Ammunition> actual = Manager.getList();

        Assert.assertEquals(excepted.get(0), actual.get(0));
        Assert.assertEquals(excepted.get(1), actual.get(1));
        Assert.assertEquals(excepted.get(2), actual.get(2));
    }

    @org.junit.Test
    public void TestGetters(){
        Manager.ClearList();

        Ammunition sword = new Sword("Iron sword", "Iron", 20, 200);
        Ammunition helmet = new Helmet("Steel helmet", "Steel", 10, 150);
        Ammunition chestplate = new Chestplate("Kevlar chestplate", "Kevlar", 30, 300);

        Manager.Add(sword);
        Manager.Add(helmet);
        Manager.Add(chestplate);

        List<Ammunition> excepted = new ArrayList<>();
        excepted.add(sword);
        List<Ammunition>  actual = Sorter.getSwords();
        Assert.assertEquals(excepted, actual);

        excepted.clear();
        excepted.add(helmet);
        actual= Sorter.getHelmets();
        Assert.assertEquals(excepted, actual);

        excepted.clear();
        excepted.add(chestplate);
        actual= Sorter.getChestplates();
        Assert.assertEquals(excepted, actual);
    }
}
