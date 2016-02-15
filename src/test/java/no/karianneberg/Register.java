package no.karianneberg;

import java.util.Arrays;
import java.util.List;

public class Register {

    private int totalPrice;
    private final List<Item> allowedItems;

    public Register(Item... items) {
        totalPrice = 0;
        allowedItems = Arrays.asList(items);
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void scan(Item item) {
        if (allowedItems.contains(item)) {
            this.totalPrice += item.getPrice();
        }
    }
}
