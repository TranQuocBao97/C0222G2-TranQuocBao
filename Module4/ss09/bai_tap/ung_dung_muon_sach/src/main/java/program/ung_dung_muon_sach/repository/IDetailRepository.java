package program.ung_dung_muon_sach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import program.ung_dung_muon_sach.model.Detail;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IDetailRepository extends JpaRepository<Detail,Integer> {

    @Query(value = " SELECT * FROM detail ",nativeQuery = true)
    List<Detail> selectAllDetail();

    @Query(value = " SELECT * FROM detail WHERE book_id = :idBookSelect ",nativeQuery = true)
    List<Detail> selectAllDetailByBookId(@Param("idBookSelect") Integer id);

    @Query(value = " SELECT * FROM detail WHERE id = :idSelect ", nativeQuery = true)
    Detail selectDetailById(@Param("idSelect") Integer id);

    @Modifying
    @Transactional
    Detail save(Detail detail);
}
