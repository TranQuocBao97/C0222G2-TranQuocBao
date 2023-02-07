package steam.crawl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import steam.crawl.model.ItemCsgo;

import java.util.List;

public interface ItemCsgoRepository extends JpaRepository<ItemCsgo, Integer> {
    @Query(value = "SELECT * FROM item_csgo", nativeQuery = true)
    List<ItemCsgo> itemCsgoList();
}
