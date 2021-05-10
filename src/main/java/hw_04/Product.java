package hw_04;

//Single-responsibility principle
//Open-closed principle

public class Product {
    private final int id;
    private final String name;
    private final Country country;
    private final double weight;
    private final int price;

    public Product(int id, String name, Country country, double weight, int price) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.weight = weight;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public double getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "id " + this.id + ": " + this.name + ", страна происхождения - " + getCountry() +
                ", вес - " + this.weight + " кг" +
                ", стоимость - " + this.price + ",00 руб.";
    }
}
