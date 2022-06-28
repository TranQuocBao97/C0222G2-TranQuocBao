package program.ung_dung_muon_sach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import program.ung_dung_muon_sach.model.CountView;

import javax.transaction.Transactional;

@Repository
public interface ICountViewRepository extends JpaRepository<CountView,String> {

    @Modifying
    @Transactional
    @Query(value = " Update count_view set view = view+1 ",nativeQuery = true)
    void add1view();
}
