package program.ung_dung_muon_sach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import program.ung_dung_muon_sach.model.Book;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {


    @Query(value = " SELECT * FROM book ",nativeQuery = true)
    List<Book> selectAllBook();

    @Query(value = " SELECT * FROM book WHERE book_id = :id ",nativeQuery = true)
    Book selectBookById(@Param("id") Integer id);

}
