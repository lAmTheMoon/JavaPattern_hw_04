package hw_04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;



public final class Order {
    private final List<OrderItem> orderItemList;

    public Order() {
        orderItemList = new ArrayList<>();
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void addProduct(OrderItem orderItem) {
        if (orderItem.getSumPrice() == 0) {
            this.orderItemList.remove(orderItem);
            return;
        }
        if (this.orderItemList.contains(orderItem)) {
            int index = this.orderItemList.indexOf(orderItem);
            int amount = this.orderItemList.get(index).getAmount();
            int totalAmount = orderItem.getAmount() + amount;
            if (totalAmount <= 0) {
                System.out.printf("Для удаления товара из заказа введите ноль.\n" +
                        "Для уменьшения выбранного товара в корзине введите число, не превышающее его количество - %d%n", amount);
                return;
            }
            this.orderItemList.set(index, new OrderItem(orderItem.getProduct(), totalAmount));
            return;
        }
        this.orderItemList.add(orderItem);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        AtomicInteger index = new AtomicInteger(1);
        this.orderItemList.forEach(o -> sb.append("# ").append(index.getAndIncrement()).append(". ").append(o));
        return sb.toString();
    }
}
