package hw_04;

import java.util.List;

public interface ProductRepository {
    List<Product> all();
    Product ofId(int id);
}
