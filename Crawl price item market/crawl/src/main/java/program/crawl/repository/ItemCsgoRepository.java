package program.crawl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import program.crawl.model.ItemCsgo;

import java.util.List;

@Repository
public interface ItemCsgoRepository extends JpaRepository<ItemCsgo, Integer> {
    @Query(value = "SELECT * FROM item_csgo", nativeQuery = true)
    List<ItemCsgo> itemCsgoList();
}
