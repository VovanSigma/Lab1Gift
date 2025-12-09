package ua.lab1.gift.model.candy;

public abstract class Candy {
    private String name;
    private double weight;        // вага однієї цукерки, г
    private double sugarContent;  // вміст цукру, г
    private double pricePerKg;    // ціна за кг

    public Candy(String name, double weight, double sugarContent, double pricePerKg) {
        this.name = name;
        this.weight = weight;
        this.sugarContent = sugarContent;
        this.pricePerKg = pricePerKg;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getSugarContent() {
        return sugarContent;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    // ціна однієї цукерки
    public double getPriceOfOne() {
        return pricePerKg * (weight / 1000.0);
    }

    @Override
    public String toString() {
        return String.format(
                "%s (%.0fg, sugar=%.1fg, price=%.2f₴)",
                name, weight, sugarContent, getPriceOfOne()
        );
    }
}
