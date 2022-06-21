package program.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.model.Product;
import program.repository.IProductRepository;
import program.service.IProductService;

import java.util.List;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public List<Product> getAll() {
        return iProductRepository.getAll();
    }

    @Override
    public void save(Product product) {
        iProductRepository.create(product);
    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public void delete(Integer id) {
        iProductRepository.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.getProductByName(name);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.getProductById(id);
    }
}
