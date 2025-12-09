package ua.lab1.gift.model.candy;

public class ChocolateCandy extends Candy {
    private double cocoaPercent;

    public ChocolateCandy(String name, double weight, double sugarContent,
                          double pricePerKg, double cocoaPercent) {
        super(name, weight, sugarContent, pricePerKg);
        this.cocoaPercent = cocoaPercent;
    }

    public double getCocoaPercent() {
        return cocoaPercent;
    }

    @Override
    public String toString() {
        return "Chocolate " + super.toString() +
                String.format(", cocoa=%.0f%%", cocoaPercent);
    }
}
