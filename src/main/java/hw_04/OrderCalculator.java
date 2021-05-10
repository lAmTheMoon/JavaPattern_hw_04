package hw_04;

public final class OrderCalculator {
    private final Order order;
    private double totalWeight;
    private int totalCost;

    public OrderCalculator(Order order) {
        this.order = order;
        this.totalWeight = calculateTotalWeight();
        this.totalCost = calculateTotalCost();
    }

    private double calculateTotalWeight() {
        return this.totalWeight = this.order.getOrderItemList().stream().mapToDouble(OrderItem::getSumWeight).sum();
    }

    private int calculateTotalCost() {
        return this.totalCost = this.order.getOrderItemList().stream().mapToInt(OrderItem::getSumPrice).sum();
    }

    @Override
    public String toString() {
        return this.order + String.format("Вес заказа: %.2f кг\nИтого к оплате: %d,00 руб.\n",
                this.totalWeight, this.totalCost);
    }
}
