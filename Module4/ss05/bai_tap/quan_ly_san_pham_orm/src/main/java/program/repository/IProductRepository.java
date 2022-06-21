package program.repository;

import program.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    void create(Product product);
    Product getProductById(Integer id);
    void delete(Integer id);
    void update(Product product);
    List<Product> getProductByName(String name);
}
