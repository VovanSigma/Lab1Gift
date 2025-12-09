package ua.lab1.gift.model.candy;

public class JellyCandy extends Candy {
    private String flavor;

    public JellyCandy(String name, double weight, double sugarContent,
                      double pricePerKg, String flavor) {
        super(name, weight, sugarContent, pricePerKg);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return "Jelly " + super.toString() +
                String.format(", flavor=%s", flavor);
    }
}
