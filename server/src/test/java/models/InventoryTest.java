package models;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void getItemsUnderPercentCapacity()
    {
        //Percent Capacity Threshold, update variable if percent changes
        double threshold = 0.25;

        List<Item> underStocked = new ArrayList<>();
        List<Item> stock = new ArrayList<>();

        /* 25.0% */ stock.add(new Item("Exactly 25", 250, 1000, 525600));
        /* 25.1% */ stock.add(new Item("Over 25", 251, 1000, 525600));
        /* 24.0% */ stock.add(new Item("Under 25 No Decimal", 240, 1000, 525600));
        /* 24.9% */ stock.add(new Item("Under 25 One Decimal", 249, 1000, 525600));
        /* 24.99% */ stock.add(new Item("Under 25 Two Decimals", 2499, 10000, 525600));
        /* 0.0% */ stock.add(new Item("No Stock", 0, 1000, 525600));
        /* -25.0% */ stock.add(new Item("How do you have negative stock", -250, 1000, 525600));

        for (Item item: stock)
        {
            double cap = ((item.getStock()*1.0)/ (item.getCapacity()*1.0));

            //Check if current capacity is less/equal to threshold AND if current capacity is not negative
            if (cap <= threshold && cap >= 0.0)
            {
                underStocked.add(item);
            }
        }

        //Based on sample data generated, I expect 5 items to be added
        assertEquals(5, underStocked.size());
    }
}