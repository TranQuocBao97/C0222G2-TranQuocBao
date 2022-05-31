package repository.impl_repository;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1,"bim bim",5000.0,"phồng tôm chiên không dầu","OShi"));
        products.add(new Product(2,"bột giặt",10000.0,"giặt máy","Omo"));
        products.add(new Product(3,"máy lạnh",50000.0,"tiết kiệm điện","Toshiba"));
        products.add(new Product(4,"Tivi",30000.0,"tivi 4k","SamSum"));
        products.add(new Product(5,"laptop",20000.0,"cấu hình cao","Asus"));
        products.add(new Product(6,"iphone",11000.0,"iphone 11","Apple"));
    }

    @Override
    public List<Product> displayAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(Integer id) {
        for(Product product : products){
            if(product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Integer id, Product product) {

    }

    @Override
    public void remove(Integer id) {
        for(Product product : products){
            if(product.getId().equals(id)){
                products.remove(product);
                break;
            }
        }
    }

    @Override
    public List<Product> search(String nameSearch) {
        List<Product> productsSearch = new ArrayList<>();
        for(Product product: products){
            if(product.getName().contains(nameSearch)){
                productsSearch.add(product);
            }
        }
        return productsSearch;
    }
}
