package service.impl_service;

import model.Product;
import repository.IProductRepository;
import repository.impl_repository.ProductRepository;
import service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    private IProductRepository iProductRepository = new ProductRepository();



    @Override
    public List<Product> displayAll() {
        return iProductRepository.displayAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {

    }

    @Override
    public void remove(Integer id) {
        iProductRepository.remove(id);
    }

    @Override
    public Integer findNextId() {
        List<Product> products = iProductRepository.displayAll();
        Integer biggerId = 0;
        for (Product product : products){
            if(product.getId()>biggerId){
                biggerId = product.getId();
            }
        }
        return biggerId+1;
    }

    @Override
    public List<Product> search(String nameSearch) {
        return iProductRepository.search(nameSearch);
    }
}
