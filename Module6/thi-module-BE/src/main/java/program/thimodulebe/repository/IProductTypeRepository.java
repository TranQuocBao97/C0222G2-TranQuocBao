package program.thimodulebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import program.thimodulebe.model.ProductType;

import java.util.List;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType, Integer> {


    @Query( value = "select * from product_type" , nativeQuery = true)
    List<ProductType> getAllTypeProduct();

}
