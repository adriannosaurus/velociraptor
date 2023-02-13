package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

class DistributorsTest
{
    List<Item> testDistributors = new ArrayList<Item>();

    @Test
    void getRestockCost()
    {
        //Starting out with two items. Same name/ID, different cost
        testDistributors.add(new Item("Existing Item", 525600, 0.25));
        testDistributors.add(new Item("Existing Item", 525600, 0.12));

        /*
        I'm not going to lie, I got kind of lost on where to start testing this method
        because of my unfamiliarity with Gson and how it is interacting with the
        code in Distributors.getRestockCost() and generating the item array.
        So that's definitely an area I would need to study to understand better
        and ultimately be comfortable unit testing :)

        Unit Test Cases I Would Create
        -One possible cost
        -2+ vendors have same cost, ensure no double calculation
        -2+ vendors have different cost, ensure using lower cost
        -No vendors have it, therefore no cost available
         */
    }
}