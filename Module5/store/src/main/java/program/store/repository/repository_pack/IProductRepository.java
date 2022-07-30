package program.store.repository.repository_pack;

import org.springframework.data.jpa.repository.JpaRepository;
import program.store.model.Product;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();
}
