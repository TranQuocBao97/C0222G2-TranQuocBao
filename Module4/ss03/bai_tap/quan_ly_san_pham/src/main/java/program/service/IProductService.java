package program.service;

import program.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    void save(Product product);

    void update(Integer id,Product product);

    void delete(Integer id);

    List<Product> findByName(String name);
    Product findById(Integer id);
}
