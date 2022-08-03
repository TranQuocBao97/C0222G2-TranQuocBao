package program.store.repository.repository_pack;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import program.store.model.Pack;

import java.util.Optional;

@Repository
public interface IPackRepository extends JpaRepository<Pack, Integer> {
    Page<Pack> findAllByProductName (String productName, Pageable pageable);

    @Query(value = " SELECT pack.* "
           + "FROM pack inner join product on pack.product_id = product.product_id "
           + "WHERE product.name like :productName ",
            countQuery = " SELECT count(*) FROM ( SELECT pack.* FROM pack inner join product on pack.product_id = product.product_id WHERE product.name like :productName ) as count_table",
            nativeQuery = true)
    Page<Pack> findAllByProductNameContaining (@Param("productName") String productName, Pageable pageable);

    Optional<Pack> findById(Integer id);
}
