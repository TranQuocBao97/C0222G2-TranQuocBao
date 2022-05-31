package repository;

import model.Product;

import java.util.List;

public interface IProductRepository{
    List<Product> displayAll();
    void save(Product product);
    Product findById(Integer id);
    void update (Integer id,Product product);
    void remove (Integer id);
    List<Product> search (String nameSearch);
}
