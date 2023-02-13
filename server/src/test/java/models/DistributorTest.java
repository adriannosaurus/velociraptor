package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;

class DistributorTest {
    List<Item> testDistributor = new ArrayList<Item>();

    @Test
    void addItem()
    {
        int before = testDistributor.size();
        int after = testDistributor.size();
        boolean isGreater = (before < after);

        //Nothing added yet
        assertFalse(isGreater, "Method requires a parameter here");
        System.out.println("Before add: " + isGreater);

        //Item added
        testDistributor.add(new Item("New Item", 525600, 0.45));
        System.out.println("Item added");
        after = testDistributor.size();
        if (after > before)
        {
            isGreater = true;
            System.out.println("After add: " + isGreater);
        }
        else
        {
            System.out.println("Nothing added");
        }
        assertTrue(isGreater, "Method requires a parameter here");
    }

    @Test
    void getCheapestCost()
    {
        //Finish in morning
    }
}