package program.quan_ly_khach_hang_phan_trang_tim_kiem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.model.Customer;
import program.quan_ly_khach_hang_phan_trang_tim_kiem.model.Province;

import java.util.List;

@Repository
public interface IProvinceRepository extends JpaRepository<Province,Integer> {

    @Query(value = " SELECT * FROM provinces ", nativeQuery = true)
    List<Province> selectAllProvince();

    Province save(Province province);

    void deleteById(Integer integer);
}
