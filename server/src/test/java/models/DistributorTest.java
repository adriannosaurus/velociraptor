package models;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DistributorTest
{
    List<Item> testDistributor = new ArrayList<Item>();

    @Test
    void addItem()
    {
        /*
        Similar to DistributorsTest.java, this test is a little tricky to me because
        I instinctively try the add() function to add items to a local ArrayList<Item>
        rather than using the Distributor.addItem() function.
        I am second guessing how to set up the test, and furthermore I am questioning
        whether void methods require unit testing since nothing is being checked
        I will leave my progress here to show my train of thought :)
         */

        Distributor localDistro = new Distributor("Clever Name Here");
        localDistro.addItem(new Item("New Item", 525600, 0.45));

        int before = testDistributor.size();
        int after = testDistributor.size();
        boolean isGreater = (before < after);

        //Nothing added yet
        assertFalse(isGreater, "Method requires a parameter here");

        //Adding new item via Distributor.addItem()
        localDistro.addItem(new Item("New Item", 525600, 0.45));
        System.out.println("Item added via Distributor.addItem()");


        //Item has been added
        after = testDistributor.size();
        if (after > before)
        {
            isGreater = true;
            assertTrue(isGreater, "Method requires a parameter here");
            System.out.println("Added successfully");
        }
        else
        {
            assertFalse(isGreater, "Method requires a parameter here");
            System.out.println("Nothing added");
        }

        //Adding new item via Distributor.addItem()
        testDistributor.add(new Item("New Item", 525600, 0.45));
        System.out.println("Item added via ArrayList<Item>.add()");


        //Item has been added
        after = testDistributor.size();
        if (after > before)
        {
            isGreater = true;
            assertTrue(isGreater, "Method requires a parameter here");
            System.out.println("Added successfully");
        }
        else
        {
            assertFalse(isGreater, "Method requires a parameter here");
            System.out.println("Nothing added");
        }

    }

    @Test
    void getCheapestCost()
    {
        /*
        THIS METHOD HAS ONE UNEXPECTED (TO ME) TEST on the assertEquals() that expects 0.75

        Originally, I had that test expecting a result of 0.45 since it is the cheaper of
        the costs for the item named "Cheaper Added Second" (0.75 and 0.45)

        I noticed that the Distributor.getCheapestCost() method does not include the logic
        for actually identifying which cost is the lowest cost. That logic is in the
        Distributors.getRestockCost() method. Rather, this method is simply called to
        parse an ArrayList<Item> and return the cost for items named X.
        So this method is essentially acting as getCost()
         */

        Distributor localDistro = new Distributor("name");
        localDistro.addItem(new Item("Only One", 234567, 0.50));
        localDistro.addItem(new Item("Cheaper Added First", 234567, 0.35));
        localDistro.addItem(new Item("Cheaper Added First", 234567, 0.45));
        localDistro.addItem(new Item("Cheaper Added Second", 345678, 0.75));
        localDistro.addItem(new Item("Cheaper Added Second", 345678, 0.45));
        localDistro.addItem(new Item("Zero Cost", 456789, 0.0));
        localDistro.addItem(new Item("Negative Cost", 567890, -0.25));

        //Test expected values
        assertEquals(0.5, localDistro.getCheapestCost("Only One"));
        assertEquals(0.35, localDistro.getCheapestCost("Cheaper Added First"));
        assertEquals(0.75, localDistro.getCheapestCost("Cheaper Added Second"));
        //Comment in/out the line above for running tests below

        //Test zero, negative, and null cost
        assertEquals(true, (localDistro.getCheapestCost("Zero Cost") >= 0.0));
        assertEquals(false, (localDistro.getCheapestCost("Negative Cost") >= 0.0));
        assertEquals(Double.MAX_VALUE, localDistro.getCheapestCost("Not In List"));
    }
}