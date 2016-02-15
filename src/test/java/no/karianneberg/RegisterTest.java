package no.karianneberg;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RegisterTest {

    private Register register;
    public static final Item BEER = new Item("Beer", 20);
    public static final Item PIZZA = new Item("Pizza", 30);

    @Before
    public void setup() {
        register = new Register(BEER, PIZZA);
    }

    @Test
    public void registerWithNoScannedItemsShouldTotalToZero() {
        assertThatTotalPriceIs(0);
    }

    @Test
    public void registerWithOneScannedItemTotalsToPriceOfItem() {
        register.scan(BEER);
        assertThatTotalPriceIs(BEER.getPrice());
    }

    @Test
    public void registerWithTwoScannedItemsShouldTotalToSumOfPriceOfItems() {
        register.scan(BEER);
        register.scan(PIZZA);

        assertThatTotalPriceIs(BEER.getPrice() + PIZZA.getPrice());
    }

    @Test
    public void scanningAnUnknownItemShouldNotAddToTotal() {
        register.scan(new Item("Unknown", 1000));
        assertThatTotalPriceIs(0);
    }

    private void assertThatTotalPriceIs(int itemPrice) {
        assertThat(register.getTotalPrice(), is(itemPrice));
    }
}