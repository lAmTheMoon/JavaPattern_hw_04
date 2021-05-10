package hw_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));
        InMemoryProductRepository repository = new InMemoryProductRepository();
        repository.all().forEach(System.out::println);
        System.out.println(instruction());
        Order order = new Order();
        obtainInformationFromUser(buffered, repository, order);
        OrderCalculator orderCalculator = new OrderCalculator(order);
        System.out.println(orderCalculator);
    }

    private static void obtainInformationFromUser(BufferedReader buffered, InMemoryProductRepository repository, Order order) throws IOException {
        String input;
        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            input = buffered.readLine();
            if ("end".equals(input)) {
                break;
            }
            if ("get".equals(input)) {
                System.out.println(order);
                continue;
            }
            String[] inputs = input.split(" ");
            int id = Integer.parseInt(inputs[0]);
            int amount = Integer.parseInt(inputs[1]);
            Product product = repository.ofId(id);
            OrderItem orderItem = new OrderItem(product, amount);
            order.addProduct(orderItem);
        }
    }

    private static String instruction() {
        return ("""
                                
                Для добавления товара в корзину введите через пробел id товара и количество;
                Для удаления товара из корзины введите через пробел id товара и ноль;
                Для уменьшения количества товара введите через пробел id товара и отрицательное число,
                на которое нужно уменьшить количество товара;
                Для просмотра содержимого заказа введите `get`
                """);
    }
}
