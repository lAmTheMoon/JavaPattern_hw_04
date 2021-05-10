package hw_04;

import java.util.Objects;

public final class OrderItem {
    private final Product product;
    private final int amount;
    private final double sumWeight;
    private final int sumPrice;

    public OrderItem(Product product, int amount) {
        this.product = product;
        this.amount = amount;
        this.sumWeight = calculateSumWeight(amount);
        this.sumPrice = calculateSumPrice(amount);
    }

    private double calculateSumWeight(int amount){
        return this.product.getWeight() * amount;
    }

    private int calculateSumPrice(int amount){
        return this.product.getPrice() * amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public double getSumWeight() {
        return sumWeight;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    @Override
    public String toString() {
        return String.format("%s, страна происхождения - %s, вес - %.2f кг, стоимость - %d,00 руб., %d уп.\n",
                this.product.getName(), this.product.getCountry(), this.sumWeight, this.sumPrice, this.amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(product, orderItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, sumWeight, sumPrice);
    }
}
