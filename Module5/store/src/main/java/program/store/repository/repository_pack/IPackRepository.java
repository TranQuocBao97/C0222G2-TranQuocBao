package program.store.repository.repository_pack;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import program.store.model.Pack;

public interface IPackRepository extends JpaRepository<Pack, Integer> {
    Page<Pack> findAllByProductName (String productName, Pageable pageable);

    @Query(value = " SELECT * FROM pack WHERE product.name like :productName ", nativeQuery = true)
    Page<Pack> findAllByProductNameContaining (@Param("productName") String productName, Pageable pageable);

}
