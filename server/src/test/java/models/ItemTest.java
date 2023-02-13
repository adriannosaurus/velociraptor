package models;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

class ItemTest
{
    Item itemDistro = new Item("Hello there", 525600, 0.25);
    Item itemInventory = new Item("General Kenobi", 25, 30, 525600);
    Item excessStock = new Item("You are a bold one", 35, 30, 525600);
    Item negativeStock = new Item("Kill him!", -25, 30, 525600);

    Item zeroCapacity = new Item("lightsaber noises", 25, 0, 525600);
    Item zeroCost = new Item("crash", 525600, 0.0);
    Item negativeCost = new Item("Your move", 525600, -0.25);

    @Test
    void getName()
    {
        assertEquals("Hello there", itemDistro.getName());
        assertEquals("General Kenobi", itemInventory.getName());
    }

    @Test
    void getStock()
    {
        //Distributor-side items do not have stock parameter
        assertEquals(0, itemDistro.getStock());
        assertEquals(25, itemInventory.getStock());

        //Ensure no negative stock
        assertEquals(false, (negativeStock.getStock() >= 0));

        //Ensure stock doesn't exceed capacity
        assertEquals(true, (itemInventory.getCapacity() >= itemInventory.getStock()));
        assertEquals(false, (excessStock.getCapacity() >= excessStock.getStock()));
    }

    @Test
    void getCapacity()
    {
        //Distributor-side items do not have capacity parameter
        assertEquals(0, itemDistro.getCapacity());
        assertEquals(30, itemInventory.getCapacity());

        //Ensure capacity is greater than 0
        assertEquals(true, (itemInventory.getCapacity() > 0));
        assertEquals(false, (zeroCapacity.getCapacity() > 0));
    }

    @Test
    void getCost()
    {
        //Inventory-side items do not have stock parameter
        assertEquals(0, itemInventory.getCost(), 0);
        assertEquals(0.25, itemDistro.getCost(), 0);

        //Ensure cost is greater than $0
        assertEquals(true, (itemDistro.getCost() > 0.0));
        assertEquals(false, (zeroCost.getCost() > 0.0));
        assertEquals(false, (negativeCost.getCost() > 0.0));

    }
}