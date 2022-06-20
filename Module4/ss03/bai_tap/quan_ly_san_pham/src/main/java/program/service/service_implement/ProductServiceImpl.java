package program.service.service_implement;

import org.springframework.stereotype.Service;
import program.model.Product;
import program.service.IProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ProductServiceImpl implements IProductService {


    private static final Map<Integer,Product> productList = new HashMap<>();

    static {
        productList.put(1,new Product(1,"Mỳ tôm","5000","Lẩu Thái"));
        productList.put(2,new Product(2,"Bim Bim","4000","Oshi ngon"));
        productList.put(3,new Product(3,"Gạo","100000","Gạo thơm"));
        productList.put(4,new Product(4,"Phở","8000","Trắng mềm"));
        productList.put(5,new Product(5,"Bánh","10000","Ngọt dịu"));
        productList.put(6,new Product(6,"Kẹo","5000","Chua ngọt"));
    }


    @Override
    public List<Product> getAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public void update(Integer id, Product product) {
        productList.put(id,product);
    }

    @Override
    public void delete(Integer id) {
        productList.remove(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for(Product product : productList.values()){
            if(product.getName().contains(name)){
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public Product findById(Integer id) {
        return productList.get(id);
    }
}
