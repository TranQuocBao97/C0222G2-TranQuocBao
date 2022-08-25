package program.thimodulebe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import program.thimodulebe.model.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Product save(Product product);

    Page<Product> findAll (Pageable pageable);

    @Query( value = "update product set is_deteled = 1 where id = :id", nativeQuery = true)
    Void deleteByIsDeleted(Integer id);

}
