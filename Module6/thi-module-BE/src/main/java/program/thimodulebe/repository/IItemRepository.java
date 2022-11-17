package program.thimodulebe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import program.thimodulebe.model.Item;

import java.util.List;

@Repository
public interface IItemRepository extends JpaRepository<Item, Integer> {

    @Query(value = "SELECT * FROM item", nativeQuery = true)
    List<Item> testList();

}
