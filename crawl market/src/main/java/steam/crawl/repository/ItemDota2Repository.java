package steam.crawl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import steam.crawl.model.ItemDota2;

import java.util.List;

public interface ItemDota2Repository extends JpaRepository<ItemDota2, Integer> {
    @Query(value = "SELECT * FROM item_dota2", nativeQuery = true)
    List<ItemDota2> itemDota2List();
}
