package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> displayAll();
    void save(Product product);
    Product findById(Integer id);
    void update (Integer id,Product product);
    void remove (Integer id);
    Integer findNextId();
    List<Product> search (String nameSearch);
}
