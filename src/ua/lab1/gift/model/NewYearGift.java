package ua.lab1.gift.model;

import ua.lab1.gift.model.candy.Candy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NewYearGift {
    private final List<Candy> candies = new ArrayList<>();

    public void addCandy(Candy candy) {
        candies.add(candy);
    }

    public List<Candy> getCandies() {
        return candies;
    }

    // загальна вага всіх цукерок
    public double getTotalWeight() {
        return candies.stream()
                .mapToDouble(Candy::getWeight)
                .sum();
    }

    // загальна ціна подарунка
    public double getTotalPrice() {
        return candies.stream()
                .mapToDouble(Candy::getPriceOfOne)
                .sum();
    }

    // сортування за цукром
    public List<Candy> sortBySugar() {
        return candies.stream()
                .sorted(Comparator.comparingDouble(Candy::getSugarContent))
                .collect(Collectors.toList());
    }

    // пошук у діапазоні цукру
    public List<Candy> findBySugarRange(double minSugar, double maxSugar) {
        return candies.stream()
                .filter(c -> c.getSugarContent() >= minSugar && c.getSugarContent() <= maxSugar)
                .collect(Collectors.toList());
    }
}
