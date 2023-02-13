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
        I'm not going to lie, I got kind of lost with unit testing this method.
        This is most likely due to my unfamiliarity with Gson and how it is
           interacting with the code in Distributors.getRestockCost()
        So that's definitely an area I would need to study a bit to get comfortable with
         */
    }
}