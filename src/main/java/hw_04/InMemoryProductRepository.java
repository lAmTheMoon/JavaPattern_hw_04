package hw_04;

import java.util.ArrayList;
import java.util.List;

//Single-responsibility principle
//Dependency inversion principle

public final class InMemoryProductRepository implements ProductRepository {
    private final List<Product> productList;

    public InMemoryProductRepository() {
        productList = addProducts();
    }

    private List<Product> addProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Яблоки", Country.CHINA, 1, 60));
        productList.add(new Product(2, "Бананы", Country.INDIA, 1, 30));
        productList.add(new Product(3, "Манго", Country.THAILAND, 0.25, 180));
        productList.add(new Product(4, "Огурцы", Country.RUSSIA, 0.5, 75));
        productList.add(new Product(5, "Картофель", Country.BELARUS, 0.7, 50));
        productList.add(new Product(6, "Капуста", Country.RUSSIA, 1.2, 15));
        productList.add(new Product(7, "Нут", Country.TURKEY, 0.5, 110));
        productList.add(new Product(8, "Рис", Country.INDIA, 0.7, 120));
        productList.add(new Product(9, "Фасоль", Country.RUSSIA, 0.5, 100));
        return productList;
    }

    public List<Product> all() {
        return productList;
    }

    public Product ofId(int id) {
        return this.productList.stream().filter((p) -> p.getId() == id).findFirst().get();
    }
}
