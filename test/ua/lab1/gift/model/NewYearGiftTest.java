package ua.lab1.gift.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.lab1.gift.model.candy.Candy;
import ua.lab1.gift.model.candy.ChocolateCandy;
import ua.lab1.gift.model.candy.JellyCandy;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewYearGiftTest {

    private NewYearGift gift;

    @BeforeEach
    public void setUp() {
        gift = new NewYearGift();
        gift.addCandy(new ChocolateCandy("Корона горіхова", 25, 12, 350, 50));
        gift.addCandy(new ChocolateCandy("Рошен класична", 20, 10, 300, 45));
        gift.addCandy(new JellyCandy("Желейка яблучна", 15, 8, 280, "apple"));
        gift.addCandy(new JellyCandy("Желейка вишнева", 15, 9, 280, "cherry"));
    }

    @Test
    public void totalWeightShouldBe75() {
        double totalWeight = gift.getTotalWeight();
        assertEquals(75.0, totalWeight, 0.0001,
                "Загальна вага має бути 75 г");
    }

    @Test
    public void totalPriceShouldBeExpected() {
        double totalPrice = gift.getTotalPrice();
        assertEquals(23.15, totalPrice, 0.001,
                "Загальна вартість має бути 23.15₴");
    }

    @Test
    public void sortBySugarShouldReturnCandiesInAscendingOrder() {
        List<Candy> sorted = gift.sortBySugar();

        double[] expectedSugar = {8.0, 9.0, 10.0, 12.0};
        for (int i = 0; i < expectedSugar.length; i++) {
            assertEquals(expectedSugar[i], sorted.get(i).getSugarContent(), 0.0001,
                    "Невірний порядок сортування за вмістом цукру");
        }
    }

    @Test
    public void findBySugarRangeShouldReturnCandiesWithinRange() {
        List<Candy> found = gift.findBySugarRange(8.0, 11.0);
        assertEquals(3, found.size(),
                "Має бути 3 цукерки у діапазоні 8–11 г цукру");
    }
}


