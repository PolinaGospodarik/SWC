package university.test;

import university.model.entity.Ammunition;
import university.model.entity.Chestplate;
import university.model.entity.Helmet;
import university.model.entity.Sword;

import static org.junit.Assert.assertEquals;

public class TestCreation {
    @org.junit.Test
    public void CreateSwords(){
        Ammunition sword = new Sword("Iron sword", "Iron", 20, 200);

        assertEquals("Iron sword", sword.getName());
        assertEquals("Iron", sword.getMaterial());
        assertEquals(20, sword.getWeight(),0.1);
        assertEquals(200, sword.getPrice(),0.1);
    }

    @org.junit.Test
    public void CreateHelmet(){
        Ammunition helmet = new Helmet("Steel helmet", "Steel", 10, 150);

        assertEquals("Steel helmet", helmet.getName());
        assertEquals("Steel", helmet.getMaterial());
        assertEquals(10, helmet.getWeight(),0.1);
        assertEquals(150, helmet.getPrice(),0.1);
    }

    @org.junit.Test
    public void CreateChestplate(){
        Ammunition chestplate = new Chestplate("Kevlar chestplate", "Kevlar", 30, 300);

        assertEquals("Kevlar chestplate", chestplate.getName());
        assertEquals("Kevlar", chestplate.getMaterial());
        assertEquals(30, chestplate.getWeight(),0.1);
        assertEquals(300, chestplate.getPrice(),0.1);
    }

}
